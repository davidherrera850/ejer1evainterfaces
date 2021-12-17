package com.example.bottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnavigation.presentation.screens.Pantalla1
import com.example.bottomnavigation.presentation.screens.Pantalla2
import com.example.bottomnavigation.presentation.screens.Pantalla3


@Composable
fun NavigationHost(
    navController:NavHostController
) {
    NavHost(navController = navController, startDestination = Destinations.Pantalla1.route ){
        composable(Destinations.Pantalla1.route){
            Pantalla1()
        }
        composable(Destinations.Pantalla2.route){
            Pantalla2()
        }
        composable(Destinations.Pantalla3.route){
            Pantalla3()
        }
    }






}