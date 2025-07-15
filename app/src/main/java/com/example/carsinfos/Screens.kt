package com.example.carsinfos

sealed class Screens(val route : String) {
    object CarLoadingScreen : Screens("car_loading_screen")
    object CarMakesScreen : Screens("car_makes_screen")
    object CarModelsScreen : Screens("car_models_screen")
    object CarYearScreen : Screens("car_year_screen")
    object CarDetailScreen : Screens("car_detail_screen")
}