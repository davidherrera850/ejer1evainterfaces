package com.example.bottomnavigation.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State

import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bottomnavigation.navigation.Destinations
import com.google.android.material.bottomappbar.BottomAppBar






@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
    )
{
    val currentRoute = currentRoute(navController = navController)
    BottomNavigation {
        items.forEach {
            screen ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = screen.icon,contentDescription = screen.title) },
                    label = { Text(text = screen.title)},
                    selected =currentRoute == screen.route ,
                    onClick = {
                              navController.navigate(screen.route) {
                                  popUpTo(navController.graph.findStartDestination().id){
                                      saveState=true
                                  }
                                  launchSingleTop=true

                              }
                    },
                    alwaysShowLabel = false  // si true muestra todos los label, false sólo el actual
                )
        }
    }
}




@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route  //////////////////
}