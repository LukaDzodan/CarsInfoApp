package com.example.carsinfos.presentation.carDetailScreen.cardList.bodies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carsinfos.domain.model.CarModelBody
import com.example.carsinfos.ui.theme.MainPurple

@Composable
fun BodiesCardListItem(
    body : CarModelBody
){
//    Log.d("motor", "$engine")
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "${body.make} ${body.model} ${body.trim} (${body.year})",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MainPurple.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text("Doors: ${body.doors ?: "N/A"}")
            Text("Seats: ${body.seats ?: "N/A"}")
            Text("Type: ${body.type ?: "N/A"}")
            Text("Length: ${body.length ?: "N/A"}")
            Text("Width: ${body.width ?: "N/A"}")
            Text("Height: ${body.height ?: "N/A"}")
            Text("Curb Weight: ${body.curb_weight ?: "N/A"} kg")
            Text("Cargo Capacity: ${body.cargo_capacity ?: "N/A"}")
            Text("Ground Clearance: ${body.ground_clearance ?: "N/A"}")
            Text("Wheel Base: ${body.wheel_base ?: "N/A"}")
        }
    }
}