package dev.edgaradrian.locriminalintent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

private const val TAG = "CrimeListFragment"

class CrimeListFragment: Fragment() {

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this).get(crimeListViewModel::class.java)
    }//crimeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }//onCreate

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }//newInstance
    }

}//CrimeListFragment