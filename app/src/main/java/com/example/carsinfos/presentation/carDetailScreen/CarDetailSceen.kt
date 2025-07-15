package com.example.carsinfos.presentation.carDetailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carsinfos.presentation.carDetailScreen.cardList.bodies.BodiesCardList
import com.example.carsinfos.presentation.carDetailScreen.cardList.engines.EnginesCardList
import com.example.carsinfos.ui.theme.MainPurple

@Composable
fun CarDetailSceen(
    viewModel: CarDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    val pagerState = rememberPagerState(initialPage = 0) {
        2
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp, top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MainPurple
                )

            }
        } else if (state.error.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.error,
                    color = MainPurple,
                    fontSize = 16.sp
                )
            }
        } else {
            Text(
                text = if (pagerState.currentPage == 0) "Engines" else "Bodies",
                modifier = Modifier.padding(top = 20.dp),
                color = MainPurple,
                fontSize = 40.sp
            )
            Text(
                text = if (pagerState.currentPage == 0) "Swipe to bodies ->" else "<- Swipe to engines",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                color = MainPurple,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            HorizontalPager(state = pagerState) {
                when (it) {

                    0 -> {
                        EnginesCardList()
                    }

                    1 -> {
                        BodiesCardList()
                    }
                }
            }
        }
    }
}

