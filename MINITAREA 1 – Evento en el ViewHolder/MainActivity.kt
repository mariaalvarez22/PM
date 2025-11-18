package com.example.minitarea1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        rvContactos.adapter = ContactoAdapter(contactos)
    }
}
