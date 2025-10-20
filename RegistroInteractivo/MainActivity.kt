package com.example.registro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val cbSports = findViewById<CheckBox>(R.id.cbSports)
        val cbMusic = findViewById<CheckBox>(R.id.cbMusic)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)
        val switchNotifications = findViewById<Switch>(R.id.switchNotifications)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Spinner adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.countries_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCountry.adapter = adapter
        }

        // Botón Enviar
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val sports = if (cbSports.isChecked) "Sí" else "No"
            val music = if (cbMusic.isChecked) "Sí" else "No"

            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1)
                findViewById<RadioButton>(selectedGenderId).text
            else "No especificado"

            val country = spinnerCountry.selectedItem.toString()
            val notifications = if (switchNotifications.isChecked) "Sí" else "No"

            val summary = """
                Nombre: $name
                Email: $email
                Deporte: $sports
                Música: $music
                Género: $gender
                País: $country
                Notificaciones: $notifications
            """.trimIndent()

            Toast.makeText(this, summary, Toast.LENGTH_LONG).show()
        }
    }
}
