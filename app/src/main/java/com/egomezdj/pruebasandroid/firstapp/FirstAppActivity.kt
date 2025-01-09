package com.egomezdj.pruebasandroid.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.egomezdj.pruebasandroid.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnGuardar = findViewById<AppCompatButton>(R.id.btnGuardar)
        val btnVolver = findViewById<AppCompatButton>(R.id.btnVolver)
        val etNombre = findViewById<AppCompatEditText>(R.id.etNombre)
        val etEdad = findViewById<AppCompatEditText>(R.id.etEdad)

        val dbHelper = DatabaseHelper(this)

        btnGuardar.setOnClickListener {
            val name = etNombre.text.toString()
            val age = etEdad.text.toString().toIntOrNull() ?: 0

            if (name.isNotEmpty() && age > 0) {
                dbHelper.insertPerson(name, age)
                Toast.makeText(this, getString(R.string.guardado,name,age), Toast.LENGTH_SHORT).show()

                // Limpiar campos de entrada
                etNombre?.text?.clear()
                etEdad?.text?.clear()
                etNombre.requestFocus()

            } else if (name.isEmpty()){
                Toast.makeText(this, getString(R.string.errnombre), Toast.LENGTH_SHORT).show()
                etNombre.requestFocus()
            } else if (age <= 0){
                Toast.makeText(this, getString(R.string.erredad), Toast.LENGTH_SHORT).show()
                etEdad.requestFocus()
            }
        }
        // Botón para volver a la actividad principal
        btnVolver.setOnClickListener {
            finish()
        }
    }
}

