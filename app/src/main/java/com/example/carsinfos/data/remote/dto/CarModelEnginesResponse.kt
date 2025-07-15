package com.example.carsinfos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CarModelEnginesResponse(
    @SerializedName("data")
    val modelEngines : List<CarModelEngineDto>
)
