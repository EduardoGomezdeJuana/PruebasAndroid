package com.egomezdj.pruebasandroid.firstapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonaDao {
    @Insert
    suspend fun insert(persona: Persona)

    @Query("SELECT * FROM Persona")
    fun getAllPersonas(): LiveData<List<Persona>>
}