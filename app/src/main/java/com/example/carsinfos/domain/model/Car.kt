package com.example.carsinfos.domain.model

data class Car(
    val engine: String,
    val fuelType: String,
    val horsepower: Int,
    val id: Int,
    val make: String,
    val model: String,
    val price: Int,
    val year: Int
)
