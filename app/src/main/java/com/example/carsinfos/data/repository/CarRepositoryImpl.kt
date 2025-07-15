package com.example.carsinfos.data.repository

import android.util.Log
import com.example.carsinfos.common.Resource
import com.example.carsinfos.data.CarApi
import com.example.carsinfos.data.remote.dto.toCarMake
import com.example.carsinfos.data.remote.dto.toCarModel
import com.example.carsinfos.data.remote.dto.toCarModelBody
import com.example.carsinfos.data.remote.dto.toCarModelEngine
import com.example.carsinfos.domain.model.CarMake
import com.example.carsinfos.domain.model.CarModelBody
import com.example.carsinfos.domain.model.CarModelEngine
import com.example.carsinfos.domain.model.CarModel
import com.example.carsinfos.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val api: CarApi,
) : CarRepository {
    override suspend fun getCarsByMakes(): Resource<List<CarMake>> {
        return try {
            val response = api.getCarByMakes()
//            Log.d("marke","${response.makes}")
            val carMakes = response.makes.map { it.toCarMake() }
//            Log.d("automoj","${carMakes}")
            Resource.Success(carMakes)
        } catch (e: Exception) {
//            Log.d("greskaa","${e.message}")
            Resource.Error(
                message = e.localizedMessage ?: "Unexpected error occurred"
            )
        }
    }

    override suspend fun getModelsByMake(make: String): Resource<List<CarModel>> {
        return try {
            val response = api.getModelsByMake(make)
            val carModels = response.models.map { it.toCarModel() }
            Resource.Success(carModels)
        } catch (e: Exception) {
            Resource.Error(
                message = e.localizedMessage ?: "Unexpected error occurred"
            )
        }
    }

    override suspend fun getModelEngines(model: String): Resource<List<CarModelEngine>> {

        return try {
            val response = api.getModelEngines(model)
            val carModels = response.modelEngines.map { it.toCarModelEngine() }
            Resource.Success(carModels)
        } catch (e: Exception) {
            Resource.Error(
                message = e.localizedMessage ?: "Unexpected error occurred"
            )
        }
    }

    override suspend fun getModelBodies(model: String): Resource<List<CarModelBody>> {
        return try {
            val response = api.getModelBodies(model)
            val carModels = response.modelBodies.map { it.toCarModelBody() }
            Resource.Success(carModels)
        } catch (e: Exception) {
            Resource.Error(
                message = e.localizedMessage ?: "Unexpected error occurred"
            )
        }
    }


}