package com.edgaradrian.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private const val EXTRA_ANSWER_IS_TRUE = "com.edgaradrian.android.geoquiz.answer_is_true"

class CheatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
    }//onCreate
}//CheatActivity