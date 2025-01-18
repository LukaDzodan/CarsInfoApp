package com.example.carsinfos.presentation.car_detail

import com.example.carsinfos.domain.model.CarDetail

data class CarDetailState(
    val isLoading : Boolean  = false,
    val car : CarDetail ?= null,
    val error : String = ""
)
