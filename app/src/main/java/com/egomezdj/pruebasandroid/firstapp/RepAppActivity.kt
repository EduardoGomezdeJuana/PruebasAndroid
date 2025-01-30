package com.egomezdj.pruebasandroid.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.egomezdj.pruebasandroid.R

class RepAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rep_app)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnAtras = findViewById<Button>(R.id.btnAtras)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val dao = AppDatabase.getDatabase(this).personDao()
        val adapter = PersonAdapter()
        recyclerView.adapter = adapter

        dao.getAllPersons().observe(this) { persons ->
            adapter.submitList(persons)
        }

    // Botón para volver a la actividad anterior
    btnAtras.setOnClickListener {
        finish()
    }
    }
}
