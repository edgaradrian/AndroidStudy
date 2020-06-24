package com.edgaradrian.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }//trueButton onClickListener

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }//falseButton onClickListener

        prevButton.setOnClickListener {
            nextQuestion(-1)
        }//prevButton onClickListener

        nextButton.setOnClickListener {
            nextQuestion(1)
        }//nextButton onClickListener

        questionTextView.setOnClickListener {
            nextQuestion(1)
        }//questionTextView onClickListener

        updateQuestion()

    }//onCreate

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }//updateQuestion

    private fun nextQuestion(forward: Int) {
        if ( (currentIndex + forward) >= 0) {
            currentIndex = (currentIndex + forward) % questionBank.size
            updateQuestion()
        }
    }//nextQuestion


    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.TOP, 0, 300)
            show()
        }

    }//checkAnswer

}//MainActivity