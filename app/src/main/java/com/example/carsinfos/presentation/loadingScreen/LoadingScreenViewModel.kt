package com.example.carsinfos.presentation.loadingScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsinfos.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadingScreenViewModel @Inject constructor(
) : ViewModel() {

    private val _changeScreen = mutableStateOf(false)
    val changeScreen = _changeScreen

    init {
        viewModelScope.launch {
            delay(3000)
            _changeScreen.value = true
        }
    }
}