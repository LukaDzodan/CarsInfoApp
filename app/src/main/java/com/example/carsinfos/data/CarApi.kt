package com.example.carsinfos.data

import com.example.carsinfos.data.remote.dto.CarMakesResponse
import com.example.carsinfos.data.remote.dto.CarModelBodiesResponse
import com.example.carsinfos.data.remote.dto.CarModelBodyDto
import com.example.carsinfos.data.remote.dto.CarModelEnginesResponse
import com.example.carsinfos.data.remote.dto.CarModelsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarApi {

    @GET("/api/makes")
    suspend fun getCarByMakes() : CarMakesResponse

    @GET("/api/models/v2")
    suspend fun getModelsByMake(@Query("make")make : String) : CarModelsResponse

    @GET("/api/engines/v2")
    suspend fun getModelEngines(@Query("model") model : String) : CarModelEnginesResponse

    @GET("/api/bodies/v2")
    suspend fun getModelBodies(@Query("model") model : String) : CarModelBodiesResponse
}