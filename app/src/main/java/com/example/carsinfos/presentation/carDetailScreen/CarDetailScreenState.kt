package com.example.carsinfos.presentation.carDetailScreen

import com.example.carsinfos.domain.model.CarMake
import com.example.carsinfos.domain.model.CarModelBody
import com.example.carsinfos.domain.model.CarModelEngine

data class CarDetailScreenState(
    val bodiesDetails : List<CarModelBody> = emptyList(),
    val enginesDetails : List<CarModelEngine> = emptyList(),
    val error: String = "",
    val isLoading : Boolean = false
)
