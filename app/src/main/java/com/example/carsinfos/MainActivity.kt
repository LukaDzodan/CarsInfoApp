package com.example.carsinfos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carsinfos.data.remote.dto.CarDto
import com.example.carsinfos.data.repository.CarRepositoryImpl
import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.presentation.car_detail.CarDetailScreen
import com.example.carsinfos.presentation.car_detail.CarDetailViewModel
import com.example.carsinfos.presentation.car_list.CarListViewModel
import com.example.carsinfos.presentation.car_list.CarListingsScreen
import com.example.carsinfos.ui.theme.CarsInfosTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarsInfosTheme {
                    //val viewModel : CarListViewModel = viewModel()

                    CarDetailScreen()
                }
            }
        }
    }

