package dev.edgaradrian.locriminalintent

import android.content.Context
import androidx.room.Room
import dev.edgaradrian.locriminalintent.database.CrimeDatabase
import java.lang.IllegalStateException

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }//initialize

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }

    }

}//CrimeRepository