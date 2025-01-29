package com.example.carsinfos.presentation.car_list

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carsinfos.domain.model.Car
import com.example.carsinfos.ui.theme.CarItemBackGround
import com.example.carsinfos.ui.theme.PurpleGrey40
import com.example.carsinfos.ui.theme.PurpleGrey80

//@Preview(showBackground = true)
@Composable
fun CarListItem(
//    car : Car,
//    onItemClick : (Car) -> Unit
) {
    Column( modifier = Modifier
        .fillMaxSize()
//        .clickable {
//            onItemClick(car)
//        }
        .padding(20.dp)
        .background(CarItemBackGround)
    ){
        Row() {
            Text(text = /*car.make+" "+car.model*/ "Toyota Corolla",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.width(150.dp))

            Text(text = /*car.price.toString()*/ "5000e",
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
                    Text(text = /*car.year.toString()*/"2011", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1.3f)
                    .padding(8.dp)
            ) {
                Column(
                    Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Engine:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = /*car.engine*/"1998", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Box(
                modifier = Modifier
                    .weight(2.1f)
                    .padding(8.dp)
            ) {
                Column(
                    Modifier.align(Alignment.Center)
                ) {
                    Text(text = "Horse Power:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = /*car.horsepower.toString()*/ "134", style = MaterialTheme.typography.bodyMedium)
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
                    Text(text = /*car.fuelType*/ "Benzine", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}