package com.example.carsinfos.presentation.loadingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carsinfos.Screens

@Composable
fun LoadingScreen(
    onNavigate : (String) -> Unit,
    viewModel: LoadingScreenViewModel = hiltViewModel()
) {
    val changeScreen by viewModel.changeScreen

    LaunchedEffect(changeScreen) {
        if(changeScreen){
        onNavigate(Screens.CarMakesScreen.route)}
    }

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("Animacija.json"))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CarInfos",
            fontSize = 80.sp,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(250.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.width(320.dp),
            textAlign = TextAlign.Center,
            text = "Explore detailed information about cars from 2015 to 2020",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
