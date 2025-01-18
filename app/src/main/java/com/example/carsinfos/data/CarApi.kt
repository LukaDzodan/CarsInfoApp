package com.example.carsinfos.data

import com.example.carsinfos.data.remote.dto.CarDetailDto
import com.example.carsinfos.data.remote.dto.CarDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CarApi {

    @GET("/api/v1/cars")
    suspend fun getCars() : List<CarDto>

    @GET("/api/v1/cars/{carId}")
    suspend fun getCarById(@Path("carId") carId : String) : CarDetailDto
}