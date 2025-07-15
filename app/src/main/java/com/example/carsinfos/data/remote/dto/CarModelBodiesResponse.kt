package com.example.carsinfos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CarModelBodiesResponse(
    @SerializedName("data")
    val modelBodies : List<CarModelBodyDto>
)
