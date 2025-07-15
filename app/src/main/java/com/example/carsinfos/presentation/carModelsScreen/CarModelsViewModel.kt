package com.example.carsinfos.presentation.carModelsScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsinfos.common.Resource
import com.example.carsinfos.domain.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarModelsViewModel @Inject constructor(
    val repository: CarRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CarModelsScreenState())
    val state: State<CarModelsScreenState> = _state
    var carMake : String = ""

    init {
         carMake = savedStateHandle.get<String>("carMake")!!
//        Log.d("marka","$carMake")
        if (!carMake.isNullOrEmpty()) {
            getCarModels(carMake)
            Log.d("modeliMrtvi", "${getCarModels(carMake)}")
        }
    }

    fun getCarModels(make: String) {

        _state.value = _state.value.copy(
            isLoading = true
        )
        viewModelScope.launch {

            val response = repository.getModelsByMake(make)

            when (response) {
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = response.message ?: "Unknown error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }

                is Resource.Success -> {
                    if (!response.data.isNullOrEmpty()) {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            models = response.data,
                            error = ""
                        )
                    } else {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = "Models for this car is not available"
                        )
                    }
                }
            }
        }
    }
}