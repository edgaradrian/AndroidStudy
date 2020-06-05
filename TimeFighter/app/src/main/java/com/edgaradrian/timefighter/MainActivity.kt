package com.edgaradrian.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var gameScoreTextview: TextView
    private lateinit var timeLeftTextView: TextView
    private lateinit var tapMeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//onCreate

    private fun incrementScore() {

    }//incrementScore

    private fun resetGame() {

    }//resetGame

    private fun startGame() {

    }//startGame

    private fun endGame() {

    }//endGame

}//MainActivity