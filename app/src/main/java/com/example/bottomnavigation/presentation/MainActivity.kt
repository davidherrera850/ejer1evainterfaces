package com.example.bottomnavigation.presentation
// Ejemplo BottomNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.navigation.Destinations
import com.example.bottomnavigation.navigation.NavigationHost
import com.example.bottomnavigation.presentation.components.BottomNavigationBar
import com.example.bottomnavigation.presentation.screens.Pantalla1
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navigationItems = listOf(
        Destinations.Pantalla1,
        Destinations.Pantalla2,
        Destinations.Pantalla3
    )
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems)}
    ) {
        NavigationHost(navController = navController)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavigationTheme {
        MainScreen()
    }
}