package com.example.carsinfos.presentation.carDetailScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsinfos.common.Resource
import com.example.carsinfos.domain.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarDetailViewModel @Inject constructor(
    private val repository: CarRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    //Pravi dizajn, kartice one
    private val _state = mutableStateOf(CarDetailScreenState())
    val state: State<CarDetailScreenState> = _state

    lateinit var year: String

    init {
        val model = savedStateHandle.get<String>("model") ?: ""
        year = savedStateHandle.get<String>("year") ?: ""
        if (model.isNotEmpty()) {
            getDetails(model)
        }
//        Log.d("svimotori","$model,$year")
    }

    fun getDetails(model: String) {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true
            )

            val bodiesResponse = repository.getModelBodies(model)
            val enginesResponse = repository.getModelEngines(model)

            Log.d("svimotori", "${bodiesResponse.data},${enginesResponse.data}")

            if (bodiesResponse is Resource.Success && enginesResponse is Resource.Success) {
                    _state.value = _state.value.copy(
                        bodiesDetails = bodiesResponse.data ?: emptyList(),
                        enginesDetails = enginesResponse.data ?: emptyList(),
                        isLoading = false,
                        error = ""
                    )
            }else {
                val errorMessage = listOfNotNull(
                    (bodiesResponse as? Resource.Error)?.message,
                    (enginesResponse as? Resource.Error)?.message,
                ).joinToString(" | ")

                _state.value = _state.value.copy(
                    error = errorMessage,
                    isLoading = false
                )
                Log.d("greskamrtva", _state.value.error)
            }
        }
    }

    fun noModelInfo(){
        _state.value = _state.value.copy(
            error = "We have no information for this model"
        )
    }
}