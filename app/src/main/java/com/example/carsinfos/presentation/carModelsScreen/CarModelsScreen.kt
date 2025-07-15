package com.example.carsinfos.presentation.carModelsScreen

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carsinfos.presentation.carMakesScreen.CarMakeItem
import com.example.carsinfos.ui.theme.MainPurple

@Composable
fun CarModelsScreen(
    selectedModel: (String) -> Unit,
    viewModel: CarModelsViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                trackColor = Color.Green
            )
        } else if (state.error.isNotEmpty()) {
            Text(
                text = state.error,
                color = MainPurple
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
                        bottom = WindowInsets.navigationBars.asPaddingValues()
                            .calculateBottomPadding(),
                    )
            ) {
                Column() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(MainPurple.copy(alpha = 0.8f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.carMake,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            fontFamily = FontFamily.SansSerif,
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    //Moras da napravis po godinama, da bi izlistao engines i bodies lepo
                    LazyColumn {
                        items(state.models) { item ->
                            CarModelItem(item, selectedModel = {
                                selectedModel(it)
                            })
                        }
                    }
                }
            }
        }
    }
}
