package com.edgaradrian.geoquiz

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.nfc.Tag
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity.kt"
private const val KEY_INDEX = "index"
private const val KEY_CHEATS = "cheats"
private const val REQUEST_CODE_CHEAT = 0
private const val MAX_CHEATS = 3

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private lateinit var cheatButton: Button
    private lateinit var cheatLinearLayout: LinearLayout
    private lateinit var cheatTokenTextView: TextView

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }//quizViewModel

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        quizViewModel.currentIndex = currentIndex

        val cheats = savedInstanceState?.getInt(KEY_CHEATS, 0) ?: 0
        quizViewModel.cheats = cheats

        Log.d(TAG, "onCreate(Bundle?) called")

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        cheatButton = findViewById(R.id.cheat_button)
        questionTextView = findViewById(R.id.question_text_view)
        cheatLinearLayout = findViewById(R.id.cheat_linear_layout)
        cheatTokenTextView = findViewById(R.id.cheat_token_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }//trueButton onClickListener

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }//falseButton onClickListener

        nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }

        cheatButton.setOnClickListener { view: View ->

            quizViewModel.increaseCheats()

            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val options = ActivityOptions.makeClipRevealAnimation(view, 0,0, view.width, view.height)
                startActivityForResult(intent, REQUEST_CODE_CHEAT, options.toBundle())
            } else {
                startActivityForResult(intent, REQUEST_CODE_CHEAT)
            }
            //startActivity(intent)


        }//cheatButton

        updateQuestion()

    }//onCreate

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            return
        }

        if (requestCode == REQUEST_CODE_CHEAT) {
            quizViewModel.isCheater = data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
        }

    }//onActivityResult

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }//updateQuestion

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = when {
            quizViewModel.isCheater -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.TOP, 0, 300)
            show()
        }

    }//checkAnswer

    private fun hideCheatButton() {
        val tokens = MAX_CHEATS - quizViewModel.cheats
        cheatTokenTextView.text = getString(R.string.cheat_token_text_view, tokens)
        if (quizViewModel.cheats >= MAX_CHEATS) {
            cheatLinearLayout.isEnabled = false
            cheatLinearLayout.visibility = View.INVISIBLE
        }
    }//hideCheatButton

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }//onStart

    override fun onResume() {
        super.onResume()
        hideCheatButton()
        Log.d(TAG, "onResume() called")
    }//onResume

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }//onPause

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
        outState.putInt(KEY_INDEX, quizViewModel.currentIndex)
        outState.putInt(KEY_CHEATS, quizViewModel.cheats)
    }//onSaveInstanceState

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }//onStop

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }//onDestroy

}//MainActivity