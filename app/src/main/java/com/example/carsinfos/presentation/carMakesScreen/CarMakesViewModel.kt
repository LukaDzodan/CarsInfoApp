package com.example.carsinfos.presentation.carMakesScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsinfos.common.Resource
import com.example.carsinfos.domain.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarMakesViewModel @Inject constructor(
    val repository: CarRepository,
) : ViewModel() {

    private val _state = mutableStateOf(CarMakesScreenState())

    val state : State<CarMakesScreenState> = _state

    init {
        getCarMakes()
    }

    fun getCarMakes() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true
            )
            val response = repository.getCarsByMakes()
            Log.d("marke","${response.data}")
            when (response) {
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        error = response.message ?: "Unknown error occurred",
                        isLoading = false
                    )
                }
                // nikad nece ni uci u Loading ovde, ali nema veze i ne treba mi je Api Success ili Error
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }

                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        makes = response.data ?: emptyList(),
                        error = "",
                        isLoading = false
                    )
                }
            }
        }
        Log.e("marke1", "$_state")


    }
}