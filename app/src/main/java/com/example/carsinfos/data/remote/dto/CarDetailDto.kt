package com.example.carsinfos.data.remote.dto

import com.example.carsinfos.domain.model.CarDetail

data class CarDetailDto(
    val color: String,
    val engine: String,
    val fuelType: String,
    val horsepower: Int,
    val id: Int,
    val make: String,
    val mileage: Int,
    val model: String,
    val price: Int,
    val transmission: String,
    val year: Int
)

fun CarDetailDto.toCarDetail() : CarDetail {
    return CarDetail(
        engine = engine,
        fuelType = fuelType,
        horsepower = horsepower,
        carId = id,
        make = make,
        model = model,
        price = price,
        year = year,
        transmission = transmission,
        color = color,
        mileage = mileage
    )
}

