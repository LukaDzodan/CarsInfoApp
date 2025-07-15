package com.example.carsinfos.domain.repository

import com.example.carsinfos.common.Resource
import com.example.carsinfos.domain.model.CarMake
import com.example.carsinfos.domain.model.CarModelBody
import com.example.carsinfos.domain.model.CarModelEngine
import com.example.carsinfos.domain.model.CarModel

interface CarRepository {

    suspend fun getCarsByMakes() : Resource<List<CarMake>>

    suspend fun getModelsByMake(make : String) :  Resource<List<CarModel>>

    suspend fun getModelEngines(model : String) : Resource<List<CarModelEngine>>

    suspend fun getModelBodies(model : String) : Resource<List<CarModelBody>>
}