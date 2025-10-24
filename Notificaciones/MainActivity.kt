package com.example.notificaciones

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "canal_cierre_parque"
    private val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ Pedir permiso para mostrar notificaciones (solo Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), 101)
        }

        // Crear el canal de notificaciones (obligatorio desde Android 8)
        crearCanalNotificacion()

        // Botones
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnSnackbar = findViewById<Button>(R.id.btnSnackbar)
        val btnNotificacion = findViewById<Button>(R.id.btnNotificacion)

        // Acción Toast
        btnToast.setOnClickListener {
            Toast.makeText(this, "Bienvenido al parque", Toast.LENGTH_SHORT).show()
        }

        // Acción Snackbar con "Deshacer"
        btnSnackbar.setOnClickListener { view ->
            val snackbar = Snackbar.make(view, "Cierre registrado", Snackbar.LENGTH_LONG)
            snackbar.setAction("Deshacer") {
                Toast.makeText(this, "Acción deshecha", Toast.LENGTH_SHORT).show()
            }
            snackbar.show()
        }

        // Acción Notificación
        btnNotificacion.setOnClickListener {
            enviarNotificacion()
        }
    }

    // --- FUNCIÓN 1: Crear canal de notificación ---
    private fun crearCanalNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nombre = "Canal Cierre Parque"
            val descripcion = "Canal para notificar el cierre del parque"
            val importancia = NotificationManager.IMPORTANCE_HIGH // 🔔 Alta prioridad (suena y aparece)
            val canal = NotificationChannel(CHANNEL_ID, nombre, importancia).apply {
                description = descripcion
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(canal)
        }
    }

    // --- FUNCIÓN 2: Enviar la notificación ---
    private fun enviarNotificacion() {
        // Intent para abrir la app al tocar la notificación
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // 🔔 Crear la notificación
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setContentTitle("Aviso del parque")
            .setContentText("El parque cierra a las 20:00 horas")
            .setStyle(NotificationCompat.BigTextStyle().bigText("El parque cierra a las 20:00 horas"))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Se cierra al tocarla

        // Mostrar la notificación
        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }
}
