package com.example.carsinfos.presentation.carMakesScreen

import com.example.carsinfos.domain.model.CarMake

data class CarMakesScreenState(
    val makes : List<CarMake> = emptyList(),
    val error: String = "",
    val isLoading : Boolean = false
)
