package com.egomezdj.pruebasandroid.firstapp

data class Person(
    val id: Long = 0,        // ID único para cada persona, asignado automáticamente
    val name: String,        // Nombre de la persona
    val age: Int             // Edad de la persona
)
