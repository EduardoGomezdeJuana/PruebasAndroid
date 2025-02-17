package com.egomezdj.pruebasandroid.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.egomezdj.pruebasandroid.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnGuardar = findViewById<AppCompatButton>(R.id.btnGuardar)
        val btnReporte = findViewById<AppCompatButton>(R.id.btnReporte)
        val btnVolver = findViewById<AppCompatButton>(R.id.btnVolver)
        val etNombre = findViewById<AppCompatEditText>(R.id.etNombre)
        val etEdad = findViewById<AppCompatEditText>(R.id.etEdad)
        val etHobbies = findViewById<AppCompatEditText>(R.id.etHobbies)
        val dao = AppDatabase.getDatabase(this).personDao()

        btnGuardar.setOnClickListener {
            val name = etNombre.text.toString()
            val age = etEdad.text.toString().toIntOrNull() ?: 0
            val hobbies = etHobbies.text.toString().split(",").map { it.trim() }

            if (name.isNotEmpty() && age > 0 && hobbies.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    val personId = dao.insertPerson(Person(name = name, age = age))
                    hobbies.forEach { hobbyName ->
                        val hobbyId = dao.insertHobby(Hobby(name = hobbyName))
                        dao.insertHobbyPerson(HobbyPerson(personId = personId, hobbyId = hobbyId))
                    }
                    //Toast.makeText(this, getString(R.string.guardado, name), Toast.LENGTH_SHORT).show()
                }
                // Limpiar campos de entrada
                etNombre?.text?.clear()
                etEdad?.text?.clear()
                etHobbies.text?.clear()
                etNombre.requestFocus()

            } else if (name.isEmpty()){
                Toast.makeText(this, getString(R.string.errnombre), Toast.LENGTH_SHORT).show()
                etNombre.requestFocus()
            } else if (age <= 0){
                Toast.makeText(this, getString(R.string.erredad), Toast.LENGTH_SHORT).show()
                etEdad.requestFocus()
            } else if (hobbies.isEmpty()){
                Toast.makeText(this, getString(R.string.errhobbies), Toast.LENGTH_SHORT).show()
                etHobbies.requestFocus()
            }
        }

        // Botón para ir a la pantalla de reporte
        btnReporte.setOnClickListener{ navigateToRepApp() }

        // Botón para volver a la actividad principal
        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun navigateToRepApp() {
        val intent = Intent(this, RepAppActivity::class.java)
        startActivity(intent)
    }
}

