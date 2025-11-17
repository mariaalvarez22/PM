package com.example.inventarioproductos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventarioproductos.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val productList = listOf(
            Product("Camiseta", 19.99, 15),
            Product("Pantalón", 29.99, 8),
            Product("Sudadera", 39.99, 5),
            Product("Zapatos", 49.99, 12),
            Product("Gorra", 9.99, 20),
            Product("Chaqueta", 59.99, 7),
            Product("Calcetines", 5.99, 50),
            Product("Mochila", 34.99, 10)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList)
    }
}
