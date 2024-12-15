package com.egomezdj.pruebasandroid.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.activity.result.contract.ActivityResultContracts
import com.egomezdj.pruebasandroid.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val etName = findViewById<AppCompatEditText>(R.id.etName)
        val etEdad = findViewById<AppCompatEditText>(R.id.etEdad)

        // Registrar el ActivityResultLauncher
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val data =result.data  // Obtenemos el intent con los datos
                val name = data?.getStringExtra("nombre")
                val age = data?.getIntExtra("edad", -1)
                //textView.text = "Nombre: $name\nEdad: $age"
            }
        }

        // Botón para abrir la segunda actividad
        btnStart.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nombre", etName)
            intent.putExtra("edad", etEdad)
            launcher.launch(intent)
        }
    }
}

