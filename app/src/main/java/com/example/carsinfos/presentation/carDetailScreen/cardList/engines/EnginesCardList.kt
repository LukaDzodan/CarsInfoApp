package com.example.carsinfos.presentation.carDetailScreen.cardList.engines

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carsinfos.presentation.carDetailScreen.CarDetailViewModel
import com.example.carsinfos.ui.theme.MainPurple

@Composable
fun EnginesCardList(
    viewModel: CarDetailViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    val filteredEngines = state.enginesDetails.filter {
        it.year.toString() == viewModel.year
    }

    if (filteredEngines.isEmpty()) {
        viewModel.noModelInfo()
        return
    }
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MainPurple.copy(alpha = 0.8f))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(filteredEngines) {
                EnginesCardListItem(it)
            }
        }
    }
}