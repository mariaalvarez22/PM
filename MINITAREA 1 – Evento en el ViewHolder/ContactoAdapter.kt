package com.example.minitarea1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactoAdapter(private val contactos: List<Contacto>) :
    RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        holder.bind(contactos[position])
    }

    override fun getItemCount(): Int = contactos.size

    inner class ContactoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)
        private val tvDepartamento: TextView = itemView.findViewById(R.id.tvDepartamento)

        private var contactoActual: Contacto? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(contacto: Contacto) {
            contactoActual = contacto
            tvNombre.text = contacto.nombre
            tvTelefono.text = "📞 ${contacto.telefono}"
            tvDepartamento.text = "Depto: ${contacto.departamento}"
        }

        override fun onClick(v: View?) {
            val c = contactoActual ?: return
            Toast.makeText(
                v?.context,
                "Has pulsado a: ${c.nombre}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
