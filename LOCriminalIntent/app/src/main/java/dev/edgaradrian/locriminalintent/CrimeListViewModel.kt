package dev.edgaradrian.locriminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel() {

   private val crimeRepository = CrimeRepository.get()
   val crimeListLiveData = crimeRepository.getCrimes()

}//CrimeListViewModel