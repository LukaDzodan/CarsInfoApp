package com.example.carsinfos.presentation.car_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carsinfos.domain.model.Car

//@Preview(showBackground = true)
@Composable
fun izgled(
    car : Car,
    onItemClick : (Car) -> Unit
) {
    Column( modifier = Modifier
        .fillMaxSize()
        .clickable {
            onItemClick(car)
        }
        .padding(20.dp)
    ){
        Row {
            Text(text = car.make+" "+car.model,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.width(180.dp))

            Text(text = car.price.toString(),
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
        }
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        Row(){
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Column(
                    Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Year:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = car.year.toString(), style = MaterialTheme.typography.bodyMedium)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1.1f)
                    .padding(8.dp)
            ) {
                Column(
                    Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Engine:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = car.engine, style = MaterialTheme.typography.bodyMedium)
                }
            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            ) {
                Column(
                    Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Horse Power:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = car.horsepower.toString(), style = MaterialTheme.typography.bodyMedium)
                }
            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            ) {
                Column(
                    Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Fuel Engine:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = car.fuelType, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}