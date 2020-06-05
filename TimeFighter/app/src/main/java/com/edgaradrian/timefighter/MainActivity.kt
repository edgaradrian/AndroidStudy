package com.edgaradrian.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var gameScoreTextview: TextView
    private lateinit var timeLeftTextView: TextView
    private lateinit var tapMeButton: Button

    private var score = 0
    private var gameStarted = false

    private lateinit var countDownTimer: CountDownTimer
    private var initialCountDown: Long = 60000
    private var countDownInterval: Long = 1000
    private var timeLeft = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameScoreTextview = findViewById(R.id.game_score_text_view)
        timeLeftTextView = findViewById(R.id.time_left_text_view)
        tapMeButton = findViewById(R.id.tap_me_button)

        tapMeButton.setOnClickListener {
            incrementScore()
        }

    }//onCreate

    private fun incrementScore() {
        score++

        val newScore = getString(R.string.your_score, score)
        gameScoreTextview.text = newScore
    }//incrementScore

    private fun resetGame() {

    }//resetGame

    private fun startGame() {

    }//startGame

    private fun endGame() {

    }//endGame

}//MainActivity