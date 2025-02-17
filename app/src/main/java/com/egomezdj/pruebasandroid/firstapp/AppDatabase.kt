package com.egomezdj.pruebasandroid.firstapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class, Hobby::class, HobbyPerson::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hobbies_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}