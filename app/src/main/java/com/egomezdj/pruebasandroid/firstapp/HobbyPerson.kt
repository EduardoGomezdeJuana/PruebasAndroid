package com.egomezdj.pruebasandroid.firstapp

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "hobby_person",
    primaryKeys = ["personId", "hobbyId"],
    foreignKeys = [
        ForeignKey(
            entity = Person::class,
            parentColumns = ["id"],
            childColumns = ["personId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Hobby::class,
            parentColumns = ["id"],
            childColumns = ["hobbyId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HobbyPerson(
    val personId: Long,
    val hobbyId: Long
)