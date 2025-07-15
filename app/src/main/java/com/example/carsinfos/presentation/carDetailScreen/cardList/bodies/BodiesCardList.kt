package com.example.carsinfos.presentation.carDetailScreen.cardList.bodies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carsinfos.presentation.carDetailScreen.CarDetailViewModel
import com.example.carsinfos.presentation.carDetailScreen.cardList.engines.EnginesCardListItem
import com.example.carsinfos.ui.theme.MainPurple

@Composable
fun BodiesCardList(
    viewModel: CarDetailViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(8.dp).fillMaxSize(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MainPurple.copy(alpha = 0.8f))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.bodiesDetails) {
                if(it.year.toString() == viewModel.year)
                    BodiesCardListItem(it)
            }
        }
    }

}