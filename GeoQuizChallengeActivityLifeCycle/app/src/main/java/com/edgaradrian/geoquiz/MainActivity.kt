package com.edgaradrian.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val TAG = "MainActivity.kt"

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_vietnam, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0
    private var isPressed = false
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate(Bundle?) called")

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }//trueButton onClickListener

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }//falseButton onClickListener

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            if (currentIndex == 0) {
                Toast.makeText(this, "Correct Answers: $correctAnswers", Toast.LENGTH_SHORT).show()
                correctAnswers = 0
            }
            updateQuestion()
        }//setOnClickListener

        updateQuestion()

    }//onCreate

    private fun updateQuestion() {
        isPressed = false
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }//updateQuestion

    private fun checkAnswer(userAnswer: Boolean) {
        if (!isPressed) {
            val correctAnswer = questionBank[currentIndex].answer

            val messageResId = if (userAnswer == correctAnswer) {
                R.string.correct_toast
            } else {
                R.string.incorrect_toast
            }

            if (messageResId == R.string.correct_toast) {
                correctAnswers += 1
            }

            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.TOP, 0, 300)
                show()
            }
        }
        isPressed = true
    }//checkAnswer

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }//onStart

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }//onResume

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }//onPause

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }//onStop

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }//onDestroy

}//MainActivity