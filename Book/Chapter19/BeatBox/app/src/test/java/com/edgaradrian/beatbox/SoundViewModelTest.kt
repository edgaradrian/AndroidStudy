package com.edgaradrian.beatbox

import org.hamcrest.core.Is.`is`
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var beatBox: BeatBox
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
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
       verify(beatBox).play(sound)
   }//callsBeatBoxPlayOnButtonClicked

}