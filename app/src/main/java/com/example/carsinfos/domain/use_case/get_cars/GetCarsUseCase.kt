package com.example.carsinfos.domain.use_case.get_cars

import com.example.carsinfos.common.Resource
import com.example.carsinfos.data.remote.dto.toCar
import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.domain.repository.CarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(
    private val repository : CarRepository
) {
    operator fun invoke(): Flow<Resource<List<Car>>> = flow {
        try {
            emit(Resource.Loading())
            val cars = repository.getCars().map { it.toCar() }
            emit(Resource.Success(cars))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e : IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}