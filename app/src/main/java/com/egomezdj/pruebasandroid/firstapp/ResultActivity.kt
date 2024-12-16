package com.egomezdj.pruebasandroid.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.egomezdj.pruebasandroid.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val txtEnviado = findViewById<TextView>(R.id.txtEnviado)
        val btnVolver = findViewById<AppCompatButton>(R.id.btnVolver)

        // Recibir los datos enviados desde FirstActivity
        val name = intent.getStringExtra("nombre")
        val age = intent.getStringExtra("edad")
        txtEnviado.text = getString(R.string.enviado, name, age)

        // Devolver los datos a la primera actividad
        btnVolver.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("nombre", name)
            resultIntent.putExtra("edad", age)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Cerrar ResultActivity
        }
    }
}
