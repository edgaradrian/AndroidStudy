package dev.edgaradrian.locriminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.edgaradrian.locriminalintent.Crime

@Database(entities = [ Crime::class ], version = 1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase: RoomDatabase() {
    
}