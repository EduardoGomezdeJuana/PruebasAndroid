package com.egomezdj.pruebasandroid.firstapp

// El adaptador para un RecyclerView sirve como intermediario entre la fuente de datos
// y la vista que se muestra en pantalla. Su función principal es proporcionar los datos
// al RecyclerView y definir cómo deben mostrarse (diseño de cada elemento en la lista).


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.egomezdj.pruebasandroid.R

class PersonaAdapter : ListAdapter<Persona, PersonaAdapter.PersonaViewHolder>(DiffCallback()) {

    // Crea las vistas de cada elemento de la lista usando 'item_persona.xml'
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(view)
    }

    // Vincula los datos a las vistas tomando los  datos específicos de la lista
    // asignandolos a los elementos visuales
    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val persona = getItem(position)
        holder.bind(persona)
    }

    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textName)
        private val ageTextView: TextView = itemView.findViewById(R.id.textAge)

        fun bind(persona: Persona) {
            nameTextView.text = persona.nombre
            ageTextView.text = persona.edad.toString()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Persona>() {
        override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean {
            return oldItem == newItem
        }
    }
}
