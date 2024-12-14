package com.egomezdj.pruebasandroid.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.egomezdj.pruebasandroid.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvResult = findViewById<TextView>(R.id.tvResult)
        // Nos da valor de la clave EXTRA_NAME si no es vacio o vacio en caso contrario
        val name:String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text = getString(R.string.respuesta, name)
    }
}