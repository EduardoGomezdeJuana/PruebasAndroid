package com.egomezdj.pruebasandroid.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.activity.result.contract.ActivityResultContracts
import com.egomezdj.pruebasandroid.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnEnviar = findViewById<AppCompatButton>(R.id.btnEnviar)
        val etNombre = findViewById<AppCompatEditText>(R.id.etNombre)
        val etEdad = findViewById<AppCompatEditText>(R.id.etEdad)
        val txtDevuelto = findViewById<TextView>(R.id.txtDevuelto)

        // Registrar el ActivityResultLauncher
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data  // Obtenemos el intent con los datos
                val name = data?.getStringExtra("nombre")
                val age = data?.getStringExtra("edad")
                txtDevuelto.text = getString(R.string.devuelto, name, age)
            }
        }

        // Botón para abrir la segunda actividad
        btnEnviar.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val name = if (etNombre.text.isNullOrBlank()) {
                getString(R.string.errnombre)
            } else {
                etNombre.text.toString()
            }
            val vedad = etEdad.text?.toString()?.toIntOrNull()
            val age = if (vedad == null || vedad <= 0) {
                getString(R.string.erredad)
            } else {
                etEdad.text.toString()
            }
            intent.putExtra("nombre", name)
            intent.putExtra("edad", age)
            launcher.launch(intent)
        }
    }
}

