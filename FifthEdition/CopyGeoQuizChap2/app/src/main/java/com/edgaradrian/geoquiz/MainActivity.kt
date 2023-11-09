package com.edgaradrian.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.edgaradrian.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_oceans, true),
        Question(R.string.question_australia, true)
    )

    private var currentIndex = 0
    private var grade = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.isEnabled = false

        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
            deactiveButtons()
        }

        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
            deactiveButtons()
        }

        binding.backButton.setOnClickListener { view: View ->
            if (currentIndex > 0) {
                currentIndex = (currentIndex - 1) % questionBank.size
            } else {
                currentIndex = questionBank.size - 1
            }
            updateQuestion()
        }

        binding.nextButton.setOnClickListener { view: View ->
            if (currentIndex < 4) {
                currentIndex = (currentIndex + 1) % questionBank.size
                updateQuestion()
                activateButtons()
            } else {
                binding.nextButton.isEnabled = false
                Toast.makeText(this, "Your grade $grade", Toast.LENGTH_SHORT).show()
            }
        }

        binding.questionTextView.setOnClickListener { view: View ->
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()

    }//onCreate

    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }//updateQuestion

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        var messageResId: Int

        if (userAnswer == correctAnswer) {
            messageResId = R.string.correct_toast
            grade += 20
        } else {
            messageResId = R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }//checkAnswer

    private fun activateButtons() {
        binding.trueButton.isEnabled = true
        binding.falseButton.isEnabled = true
    }//activateButtons

    private fun deactiveButtons() {
        binding.trueButton.isEnabled = false
        binding.falseButton.isEnabled = false
    }

}