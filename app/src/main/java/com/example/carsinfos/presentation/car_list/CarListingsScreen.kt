package com.example.carsinfos.presentation.car_list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.carsinfos.data.CarApi
import com.example.carsinfos.data.remote.dto.toCar
import com.example.carsinfos.data.repository.CarRepositoryImpl
import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.domain.repository.CarRepository
import com.example.carsinfos.domain.use_case.get_cars.GetCarsUseCase
import com.example.carsinfos.presentation.car_detail.CarDetailState
import javax.inject.Inject

@Composable
fun CarListingsScreen (
    state : CarListState
) {
    if(state.isLoading){
        Text(text = state.cars[1].toString())
    }else
    {
        Text(text = state.error)
    }
}