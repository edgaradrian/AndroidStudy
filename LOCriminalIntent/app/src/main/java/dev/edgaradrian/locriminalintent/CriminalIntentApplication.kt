package dev.edgaradrian.locriminalintent

import android.app.Application

class CriminalIntentApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }//onCreate

}//CriminalIntentApplication