package com.example.carsinfos.presentation.car_list

import com.example.carsinfos.domain.model.Car

data class CarListState(
    val isLoading : Boolean  = false,
    val cars : List<Car> = emptyList(),
    val error : String = ""
    )
