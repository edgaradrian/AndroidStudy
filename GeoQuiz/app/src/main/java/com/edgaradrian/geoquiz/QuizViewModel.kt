package com.edgaradrian.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {

    init {
        Log.d(TAG, "ViewModel instance created")
    }//init

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }//onCleared

}//QuizViewModel