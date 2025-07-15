package com.example.carsinfos.presentation.carModelsScreen

import com.example.carsinfos.domain.model.CarModel

data class CarModelsScreenState(
    val models : List<CarModel> = emptyList(),
    val error: String = "",
    val isLoading : Boolean = false
)
