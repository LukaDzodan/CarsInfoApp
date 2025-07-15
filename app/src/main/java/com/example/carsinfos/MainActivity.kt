package com.example.carsinfos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.carsinfos.data.repository.CarRepositoryImpl
import com.example.carsinfos.presentation.carMakesScreen.CarMakesScreen
import com.example.carsinfos.presentation.carModelsScreen.CarModelsScreen
import com.example.carsinfos.presentation.carYearScreen.CarYearScreen
import com.example.carsinfos.presentation.loadingScreen.LoadingScreen
import com.example.carsinfos.ui.theme.CarsInfosTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.carsinfos.Screens
import com.example.carsinfos.Screens.CarDetailScreen
import com.example.carsinfos.presentation.carDetailScreen.CarDetailSceen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarsInfosTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screens.CarLoadingScreen.route
                ) {
                    composable(
                        route = Screens.CarLoadingScreen.route
                    ) {
                        LoadingScreen(onNavigate = { route ->
                            navController.navigate(route)
                        })
                    }
                    composable(
                        route = Screens.CarMakesScreen.route
                    ) {
                        CarMakesScreen(makeChose = {
                            navController.navigate(Screens.CarModelsScreen.route + "/$it")
                        })
                    }
                    composable(
                        route = Screens.CarModelsScreen.route + "/{carMake}",
                        arguments = listOf(
                            navArgument("carMake") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        CarModelsScreen(
                            selectedModel = {
                                navController.navigate(Screens.CarYearScreen.route + "/$it")
                            }
                        )
                    }
                    composable(
                        route = Screens.CarYearScreen.route + "/{model}",
                        arguments = listOf(
                            navArgument("model") {
                                type = NavType.StringType
                            },
                        )
                    ) {
                        val model = it.arguments?.getString("model") ?: ""
                        CarYearScreen(
                            selectedYear = {
                                navController.navigate(Screens.CarDetailScreen.route+"/$model/$it")
                            }
                        )
                    }
                    composable(
                        route = Screens.CarDetailScreen.route + "/{model}/{year}",
                        arguments = listOf(
                            navArgument("model") {
                                type = NavType.StringType
                            },
                            navArgument("year") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        CarDetailSceen()
                    }
                }
            }
        }
    }
}

