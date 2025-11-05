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

        val layoutPrincipal = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val etNombre = findViewById<EditText>(R.id.etNombrePlanta)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        ViewCompat.setOnApplyWindowInsetsListener(layoutPrincipal) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Acción al pulsar "Guardar"
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Introduce el nombre de la planta", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar el diálogo de confirmación
                val dialog = ConfirmDialog(
                    onConfirm = {
                        Snackbar.make(layoutPrincipal, "Datos guardados", Snackbar.LENGTH_SHORT).show()
                    },
                    onCancel = {
                        Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show()
                    }
                )
                dialog.show(supportFragmentManager, "ConfirmDialog")
            }
        }
    }
}
