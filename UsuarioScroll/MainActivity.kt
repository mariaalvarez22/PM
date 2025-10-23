package com.example.usuarioscroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerMas = findViewById<Button>(R.id.btnVerMas)
        btnVerMas.setOnClickListener {
            Toast.makeText(this, "Botón pulsado: Ver más", Toast.LENGTH_SHORT).show()
        }

        val switchModoOscuro = findViewById<Switch>(R.id.switchModoOscuro)
        switchModoOscuro.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Modo oscuro activado (no funcional aún)", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Modo oscuro desactivado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
