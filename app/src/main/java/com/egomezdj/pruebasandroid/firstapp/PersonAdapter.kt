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

class PersonAdapter : ListAdapter<Person, PersonAdapter.PersonViewHolder>(DiffCallback()) {

    // Crea las vistas de cada elemento de la lista usando 'item_person.xml'
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    // Vincula los datos a las vistas tomando los  datos específicos de la lista
    // asignandolos a los elementos visuales
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = getItem(position)
        holder.bind(person)
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textName)
        private val ageTextView: TextView = itemView.findViewById(R.id.textAge)

        fun bind(person: Person) {
            nameTextView.text = person.name
            ageTextView.text = person.age.toString()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }
}
