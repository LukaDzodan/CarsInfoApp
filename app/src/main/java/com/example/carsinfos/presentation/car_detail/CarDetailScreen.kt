package com.example.carsinfos.presentation.car_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carsinfos.domain.model.CarDetail
import com.example.carsinfos.ui.theme.CarItemBackGround

@Preview(showBackground = true)
@Composable
fun CarDetailScreen(
    //viewModel: CarDetailViewModel = hiltViewModel()
) {
    //val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)){

//        state.car?.let { car ->
//            Text(text = "Totoya Corolla")
//        }
        Column(modifier = Modifier.fillMaxSize() ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)) {
                Text(text = "Totoya Corolla", modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.headlineLarge,
                )
            }
            Row(
                Modifier
                    .background(CarItemBackGround)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "5000e", style = MaterialTheme.typography.headlineSmall)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Year:",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(text = "2011", style = MaterialTheme.typography.headlineSmall)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Engine:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(text = "1996", style = MaterialTheme.typography.headlineSmall)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Horse Power:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(text = "130", style = MaterialTheme.typography.headlineSmall)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Fuel Type:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(text = "Benzine", style = MaterialTheme.typography.headlineSmall)
            }
            Spacer(modifier = Modifier.height(16.dp))


            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Additional Information",
                    style = MaterialTheme.typography.headlineMedium
                    )
            }

            HorizontalDivider(color = CarItemBackGround, thickness = 2.dp)

            Spacer(modifier = Modifier.height(16.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Transmission:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(text = "Front", style = MaterialTheme.typography.headlineSmall)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Mileage:",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(text = "110126", style = MaterialTheme.typography.headlineSmall)
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

