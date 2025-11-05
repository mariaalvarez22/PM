package com.example.minitarea1

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "riego_automatico_channel"
    private val NOTIFICATION_ID = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajuste visual
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a vistas
        val layoutPrincipal = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val etNombre = findViewById<EditText>(R.id.etNombrePlanta)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnAviso = findViewById<Button>(R.id.btnAviso)
        val btnNotificacion = findViewById<Button>(R.id.btnNotificacion)

        // 1️⃣ Toast al guardar
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isNotEmpty()) {
                Toast.makeText(this, "Planta guardada correctamente 🌿", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Introduce el nombre de la planta", Toast.LENGTH_SHORT).show()
            }
        }

        // 2️⃣ Snackbar con acción
        btnAviso.setOnClickListener {
            Snackbar.make(layoutPrincipal, "Se ha realizado una acción", Snackbar.LENGTH_LONG)
                .setAction("Deshacer") {
                    Toast.makeText(this, "Acción cancelada", Toast.LENGTH_SHORT).show()
                }.show()
        }

        // 3️⃣ Crear canal de notificación
        createNotificationChannel()

        // 4️⃣ Botón enviar notificación
        btnNotificacion.setOnClickListener {
            enviarNotificacion()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Canal de Riego Automático"
            val descriptionText = "Notificaciones del sistema de riego automático"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun enviarNotificacion() {
        // Intent para abrir la app al tocar la notificación
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Crear la notificación
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_popup_reminder)
            .setContentTitle("Smart Garden")
            .setContentText("Riego automático activado a las 20:00 🌧️")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        // Verificar permiso (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1
                )
                return
            }
        }

        // Mostrar la notificación
        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, builder.build())
        }

        Toast.makeText(this, "Notificación enviada ✅", Toast.LENGTH_SHORT).show()
    }
}
