package com.example.minitarea1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactos = listOf(
            Contacto("Juan Pérez", "123456789", "Ventas"),
            Contacto("María López", "987654321", "Marketing"),
            Contacto("Carlos Gómez", "555555555", "RRHH")
        )

        val rvContactos: RecyclerView = findViewById(R.id.rvContactos)
        rvContactos.layoutManager = LinearLayoutManager(this)

        // Adapter con callback
        val adapter = ContactoAdapter(contactos) { contacto ->
            // Aquí decide la Activity qué pasa al hacer clic
            val rootView = findViewById<RecyclerView>(R.id.rvContactos)
            Snackbar.make(
                rootView,
                "Contacto seleccionado: ${contacto.nombre}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        rvContactos.adapter = adapter
    }
}
