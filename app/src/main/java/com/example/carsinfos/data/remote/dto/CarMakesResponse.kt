package com.example.carsinfos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CarMakesResponse(
    @SerializedName("data")
    val makes : List<CarMakeDto>
)

fun CarMakesResponse.toCarMakesDto() : List<CarMakeDto> {

    return makes.map {
        CarMakeDto(
            id = it.id,
            name = it.name
        )
    }

}