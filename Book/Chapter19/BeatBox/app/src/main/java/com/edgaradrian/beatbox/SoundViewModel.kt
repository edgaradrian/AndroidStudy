package com.edgaradrian.beatbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel : BaseObservable() {

    fun onButtonClicked() {

    }//onButtonClicked

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }

   @get:Bindable
    val title: String?
        get() = sound?.name

}//class SoundViewModel