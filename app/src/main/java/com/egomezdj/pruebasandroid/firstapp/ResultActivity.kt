package com.egomezdj.pruebasandroid.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.egomezdj.pruebasandroid.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnReturn = findViewById<TextView>(R.id.btnResult)

        // Recibir los datos enviados desde FirstActivity
        val name = intent.getStringExtra("nombre")
        val age = intent.getIntExtra("edad", -1)
//      tvResult.text = getString(R.string.respuesta, name, age)

        // Devolver los datos a la primera actividad
        btnReturn.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("nombre", name)
            resultIntent.putExtra("edad", age)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Cerrar ResultActivity
        }
    }
}
