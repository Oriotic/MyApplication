package com.example.myapplication

import java.io.Serializable

data class Vehicle(
    val name: String,
    val price: Double,
    val imageRes: Int
) : Serializable