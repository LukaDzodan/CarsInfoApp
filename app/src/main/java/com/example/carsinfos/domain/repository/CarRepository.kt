package com.example.carsinfos.domain.repository

import com.example.carsinfos.data.remote.dto.CarDetailDto
import com.example.carsinfos.data.remote.dto.CarDto
import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.domain.model.CarDetail

interface CarRepository {
    suspend fun getCars() : List<CarDto>

    suspend fun getCarById(carId : String) : CarDetailDto
}