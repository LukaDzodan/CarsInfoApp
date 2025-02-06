package com.example.carsinfos.presentation.car_list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.carsinfos.Screens
import com.example.carsinfos.data.CarApi
import com.example.carsinfos.data.remote.dto.CarDto
import com.example.carsinfos.data.remote.dto.toCar
import com.example.carsinfos.data.repository.CarRepositoryImpl
import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.domain.repository.CarRepository
import com.example.carsinfos.domain.use_case.get_cars.GetCarsUseCase
import com.example.carsinfos.presentation.car_detail.CarDetailScreen
import com.example.carsinfos.presentation.car_detail.CarDetailState
import javax.inject.Inject

@Composable
fun CarListingsScreen(
    navController: NavController,
    viewModel: CarListViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.cars) { car ->
                CarListItem(
                    car = car,
                    onItemClick = {
                        navController.navigate(Screens.CarDetailScreen.route + "/${car.id}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
