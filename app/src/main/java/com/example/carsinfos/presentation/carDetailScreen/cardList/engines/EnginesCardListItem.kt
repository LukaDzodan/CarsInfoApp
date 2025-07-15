package com.example.carsinfos.presentation.carDetailScreen.cardList.engines

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
import com.example.carsinfos.domain.model.CarModelEngine
import com.example.carsinfos.ui.theme.MainPurple

@Composable
fun EnginesCardListItem(
    engine : CarModelEngine
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
                text = "${engine.make} ${engine.model} ${engine.trim} (${engine.year})",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MainPurple.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text("Engine Type: ${engine.engine_type}")
            Text("Size: ${engine.size}")
            Text("Horsepower: ${engine.horsepower_hp} HP @ ${engine.horsepower_rpm} RPM")
            Text("Torque: ${engine.torque_ft_lbs} ft-lbs @ ${engine.torque_rpm} RPM")
            Text("Cylinders: ${engine.cylinders}")
            Text("Valves: ${engine.valves}")
            Text("Valve Timing: ${engine.valve_timing}")
        }
    }
}