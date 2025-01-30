package com.egomezdj.pruebasandroid.firstapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert
    suspend fun insert(person: Person)

    @Query("SELECT * FROM Person")
    fun getAllPersons(): LiveData<List<Person>>
}