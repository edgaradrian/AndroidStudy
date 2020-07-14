package dev.edgaradrian.locriminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.edgaradrian.locriminalintent.Crime

@Database(entities = [ Crime::class ], version = 1)
abstract class CrimeDatabase: RoomDatabase() {

}