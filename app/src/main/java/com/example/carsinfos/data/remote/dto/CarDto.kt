package com.example.carsinfos.data.remote.dto

import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.domain.model.CarDetail

data class CarDto(
    val engine: String,
    val fuelType: String,
    val horsepower: Int,
    val id: Int,
    val make: String,
    val model: String,
    val price: Int,
    val year: Int
)

fun CarDto.toCar() : Car {
    return Car(
         engine = engine,
         fuelType = fuelType,
         horsepower = horsepower,
         id = id,
         make = make,
         model = model,
         price = price,
         year = year
    )
}

