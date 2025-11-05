package com.example.minitarea1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajuste visual de bordes
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias
        val layoutPrincipal = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val etNombre = findViewById<EditText>(R.id.etNombrePlanta)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnAviso = findViewById<Button>(R.id.btnAviso)

        // 1️⃣ Toast al pulsar "Guardar"
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isNotEmpty()) {
                Toast.makeText(this, "Planta guardada correctamente 🌿", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Introduce el nombre de la planta", Toast.LENGTH_SHORT).show()
            }
        }

        // 2️⃣ Snackbar al pulsar "Mostrar aviso"
        btnAviso.setOnClickListener {
            Snackbar.make(layoutPrincipal, "Se ha realizado una acción", Snackbar.LENGTH_LONG)
                .setAction("Deshacer") {
                    Toast.makeText(this, "Acción cancelada", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}
