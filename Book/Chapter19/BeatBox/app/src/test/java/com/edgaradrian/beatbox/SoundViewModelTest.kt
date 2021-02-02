package com.edgaradrian.beatbox

import org.hamcrest.core.Is.`is`
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class SoundViewModelTest {

    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        sound = Sound("assetPath")
        subject = SoundViewModel()
        subject.sound= sound
    }//setUp

   @Test
   fun exposesSoundNameAsTitle() {
       assertThat(subject.title, `is`(sound.name))
   }//exposesSoundNameAsTitle

   @Test
   fun callsBeatBoxPlayOnButtonClicked() {
       subject.onButtonClicked()
   }//callsBeatBoxPlayOnButtonClicked

}