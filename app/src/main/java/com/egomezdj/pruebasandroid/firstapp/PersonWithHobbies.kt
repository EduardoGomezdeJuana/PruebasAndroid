package com.egomezdj.pruebasandroid.firstapp

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction

data class PersonWithHobbies(
    @Embedded val person: Person,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = HobbyPerson::class,
            parentColumn = "personId",
            entityColumn = "hobbyId"
        )
    )
    val hobbies: List<Hobby>
)