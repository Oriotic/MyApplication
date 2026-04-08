package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    private lateinit var vehicle: Vehicle

    private lateinit var tvName: TextView
    private lateinit var tvBasePrice: TextView
    private lateinit var tvTotal: TextView

    private lateinit var radioStandard: RadioButton
    private lateinit var radioExpress: RadioButton
    private lateinit var btnPay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Bind views
        tvName = findViewById(R.id.tvName)
        tvBasePrice = findViewById(R.id.tvBasePrice)
        tvTotal = findViewById(R.id.tvTotal)

        radioStandard = findViewById(R.id.radioStandard)
        radioExpress = findViewById(R.id.radioExpress)
        btnPay = findViewById(R.id.btnPay)

        // Get data from previous page
        vehicle = intent.getSerializableExtra("vehicle") as Vehicle

        // Show data
        tvName.text = vehicle.name
        tvBasePrice.text = "Price: $${vehicle.price}"

        // Initial calculation
        calculateTotal()

        // Listen for shipping changes
        radioStandard.setOnClickListener {
            calculateTotal()
        }

        radioExpress.setOnClickListener {
            calculateTotal()
        }

        // Pay button
        btnPay.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateTotal() {
        val discount = vehicle.price * 0.05
        val discountedPrice = vehicle.price - discount

        val shipping = if (radioExpress.isChecked) 1700.0 else 0.0

        val total = discountedPrice + shipping

        tvTotal.text = "Total: $%.2f".format(total)
    }
}