package com.example.carsinfos.data.remote.dto

import com.example.carsinfos.domain.model.CarModel

data class CarModelDto(
    val id: Int,
    val make: String,
    val make_id: Int,
    val name: String
)

fun CarModelDto.toCarModel() : CarModel {
    return CarModel(
        id = id,
        make = make,
        make_id = make_id,
        name = name
    )
}