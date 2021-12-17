package com.example.bottomnavigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title:String,
    val icon: ImageVector
) {
    object Pantalla1: Destinations("pantalla1","Pantalla 1",Icons.Filled.Clear)
    object Pantalla2: Destinations("pantalla2","Pantalla 2",Icons.Filled.Edit)
    object Pantalla3: Destinations("pantalla3","Pantalla 3",Icons.Filled.AccountBox)
}