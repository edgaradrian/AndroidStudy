package com.edgaradrian.geoquiz

import androidx.lifecycle.ViewModel


class QuizViewModel: ViewModel() {

    var currentIndex = 0
    var isCheater = false
    var cheats = 0

    private val questionBank = listOf(
        Question(R.string.question_vietnam, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    val currentQuestionAnswer: Boolean
    get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
    get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }//moveToNext

    fun increaseCheats() {
        cheats += 1
    }//increaseCheats

}//QuizViewModel