package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val vehicles = listOf(
            Vehicle("BMW M3 (F80)", 38000.0, R.drawable.bmw),
            Vehicle("Mercedes-Benz CLA", 46400.0, R.drawable.mercedes),
            Vehicle("Porsche 911 GT3 RS", 189000.0, R.drawable.porsche),
            Vehicle("Ferrari 488 Spider", 260000.0, R.drawable.ferrari)
        )

        val adapter = VehicleAdapter(vehicles) { selectedVehicle ->
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("vehicle", selectedVehicle)
            startActivity(intent)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
}