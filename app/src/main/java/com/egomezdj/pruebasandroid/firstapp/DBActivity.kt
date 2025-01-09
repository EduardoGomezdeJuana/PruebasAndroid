package com.egomezdj.pruebasandroid.firstapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "PersonDatabase", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Persons (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Persons")
        onCreate(db)
    }

    fun insertPerson(name: String, age: Int) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("age", age)
        }
        db.insert("Persons", null, values)
    }

    fun getAllPersons(): List<Person> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Persons", null)
        val personList = mutableListOf<Person>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
                personList.add(Person(id, name, age))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return personList
    }
}
