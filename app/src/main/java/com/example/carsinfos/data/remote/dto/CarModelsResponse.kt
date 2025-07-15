package com.example.carsinfos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CarModelsResponse(
    @SerializedName("data")
    val models : List<CarModelDto>
)
