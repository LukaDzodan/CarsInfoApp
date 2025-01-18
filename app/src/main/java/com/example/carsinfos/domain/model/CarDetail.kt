package com.example.carsinfos.domain.model

data class CarDetail(
    val color: String,
    val engine: String,
    val fuelType: String,
    val horsepower: Int,
    val carId: Int,
    val make: String,
    val mileage: Int,
    val model: String,
    val price: Int,
    val transmission: String,
    val year: Int
)
