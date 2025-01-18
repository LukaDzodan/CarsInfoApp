package com.example.carsinfos.presentation.car_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsinfos.common.Constants
import com.example.carsinfos.common.Resource
import com.example.carsinfos.domain.use_case.get_car.GetCarDetailUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CarDetailViewModel @Inject constructor(
    private val getCarDetailUseCase: GetCarDetailUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(CarDetailState())
    val state : State<CarDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CAR_ID)?.let { carId ->
            getCar(carId)
        }
    }

    private fun getCar(carId : String) {
        getCarDetailUseCase(carId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CarDetailState(
                        car = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value = CarDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CarDetailState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}