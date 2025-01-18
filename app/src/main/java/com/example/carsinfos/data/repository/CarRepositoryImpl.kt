package com.example.carsinfos.data.repository

import com.example.carsinfos.data.CarApi
import com.example.carsinfos.data.remote.dto.CarDetailDto
import com.example.carsinfos.data.remote.dto.CarDto
import com.example.carsinfos.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val api : CarApi
) : CarRepository  {

    override suspend fun getCars(): List<CarDto> {
       return api.getCars()
    }

    override suspend fun getCarById(carId: String): CarDetailDto {
        return api.getCarById(carId)
    }
}