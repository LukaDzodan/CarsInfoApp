package com.example.carsinfos.domain.use_case.get_car

import com.example.carsinfos.common.Resource
import com.example.carsinfos.data.remote.dto.toCarDetail
import com.example.carsinfos.domain.model.CarDetail
import com.example.carsinfos.domain.repository.CarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCarDetailUseCase @Inject constructor(
    private val repository : CarRepository
) {
    operator fun invoke(carId : String): Flow<Resource<CarDetail>> = flow {
        try {
            emit(Resource.Loading())
            val car = repository.getCarById(carId).toCarDetail()
            emit(Resource.Success(car))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e : IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}