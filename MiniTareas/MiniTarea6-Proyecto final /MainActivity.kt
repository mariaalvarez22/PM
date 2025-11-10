package com.example.minitarea6

import com.example.minitarea6.R
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val channelId = "mi_canal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)

        // Pedir permiso de notificaciones en Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1)
            }
        }

        // Botón Toast
        findViewById<Button>(R.id.btnToast).setOnClickListener {
            Toast.makeText(this, "Toast funcionando", Toast.LENGTH_SHORT).show()
        }

        // Botón Snackbar
        findViewById<Button>(R.id.btnSnackbar).setOnClickListener {
            Snackbar.make(mainLayout, "Snackbar funcionando", Snackbar.LENGTH_LONG)
                .setAction("Deshacer") { Toast.makeText(this, "Acción deshecha", Toast.LENGTH_SHORT).show() }
                .show()
        }

        // Botón Notificación
        findViewById<Button>(R.id.btnNotification).setOnClickListener {
            showNotification()
        }

        createNotificationChannel()
    }

    // Crear canal de notificación (Android 8+)
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Canal de ejemplo"
            val descriptionText = "Canal para Minitarea_6"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = descriptionText
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Notificación")
            .setContentText("Este es un ejemplo de notificación")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notification)
    }

    // Menú superior
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                Toast.makeText(this, "Ajustes seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_about -> {
                showConfirmationDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Diálogo de confirmación
    private fun showConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Confirmación")
            .setMessage("¿Quieres continuar?")
            .setPositiveButton("Sí") { dialog, _ ->
                Toast.makeText(this, "Continuando...", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
