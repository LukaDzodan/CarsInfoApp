package com.example.carsinfos.presentation.car_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsinfos.common.Resource
import com.example.carsinfos.domain.use_case.get_cars.GetCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CarListState())
    val state : State<CarListState> = _state

    init {
        getCars()
    }

    private fun getCars() {
        getCarsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CarListState(
                        cars = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = CarListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CarListState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}