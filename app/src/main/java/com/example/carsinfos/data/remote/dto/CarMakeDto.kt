package com.example.carsinfos.data.remote.dto

import com.example.carsinfos.domain.model.CarMake

data class CarMakeDto(
    val id: Int,
    val name: String
)

fun CarMakeDto.toCarMake() : CarMake {
    return CarMake(
        id = id,
        name = name
    )
}