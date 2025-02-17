package com.egomezdj.pruebasandroid.firstapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hobby")
data class Hobby(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)