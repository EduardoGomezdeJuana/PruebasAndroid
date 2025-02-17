package com.egomezdj.pruebasandroid.firstapp

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface PersonDao {

    @Insert
    suspend fun insertPerson(person: Person): Long

    @Insert
    suspend fun insertHobby(hobby: Hobby): Long

    @Insert
    suspend fun insertHobbyPerson(hobbyPerson: HobbyPerson)

    @Transaction
    @Query("SELECT * FROM person")
    suspend fun getPersonsWithHobbies(): List<PersonWithHobbies>
}

