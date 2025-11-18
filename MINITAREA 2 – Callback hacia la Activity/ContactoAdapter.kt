package com.example.minitarea1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactoAdapter(
    private val contactos: List<Contacto>,
    private val onItemClick: (Contacto) -> Unit  // callback hacia la Activity
) : RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        holder.bind(contactos[position], onItemClick)
    }

    override fun getItemCount(): Int = contactos.size

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)
        private val tvDepartamento: TextView = itemView.findViewById(R.id.tvDepartamento)

        fun bind(contacto: Contacto, onItemClick: (Contacto) -> Unit) {
            tvNombre.text = contacto.nombre
            tvTelefono.text = "📞 ${contacto.telefono}"
            tvDepartamento.text = "Depto: ${contacto.departamento}"

            itemView.setOnClickListener {
                onItemClick(contacto) // avisamos a la Activity
            }
        }
    }
}
