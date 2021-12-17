package com.example.bottomnavigation.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.URL

@Composable
fun Pantalla1(){
    var textFieldValueNombre by rememberSaveable { mutableStateOf("") }
    var textFieldValueEquipo by rememberSaveable { mutableStateOf("") }
    var textFieldValuePosicion by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()


    ) {
        Text(
            text = "SQL INSERT",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )


        TextField(
            value = textFieldValueNombre,
            onValueChange = { nuevo ->
                textFieldValueNombre = nuevo
            },
            label = {
                Text(text = "Introducir nombre")
            },
            modifier = Modifier
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(textAlign = TextAlign.Right)
        )


        TextField(
            value = textFieldValueEquipo,
            onValueChange = { nuevo ->
                textFieldValueEquipo = nuevo
            },
            label = {
                Text(text = "Introducir equipo")
            },
            modifier = Modifier
                .padding( 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(textAlign = TextAlign.Right)
        )


        TextField(
            value = textFieldValuePosicion,
            onValueChange = { nuevo ->
                textFieldValuePosicion = nuevo
            },
            label = {
                Text(text = "Introducir posicion")
            },
            modifier = Modifier
                .padding( 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(textAlign = TextAlign.Right)
        )

        Spacer(Modifier.height(20.dp) )


        Button(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .size(width = 100.dp, height = 50.dp)
            ,


            onClick = {
                insertar(textFieldValueNombre,textFieldValueEquipo,textFieldValuePosicion)
                textFieldValueNombre=""
                textFieldValueEquipo=""
                textFieldValuePosicion=""
            }
        ){
            Text(text = "Insert"
            )
        }


    }
}

fun insertar(nombre:String,equipo:String,posicion:String){

    val url = "http://iesayala.ddns.net/deivid1022/insertjugadores.php/?nombre=$nombre&equipo=$equipo&posicion=$posicion"

    leerUrl(url)

}


fun leerUrl(urlString:String){
    GlobalScope.launch(Dispatchers.IO)   {
        val response = try {
            URL(urlString)
                .openStream()
                .bufferedReader()
                .use { it.readText() }
        } catch (e: IOException) {
            "Error with ${e.message}."
            Log.d("io", e.message.toString())
        } catch (e: Exception) {
            "Error with ${e.message}."
            Log.d("io", e.message.toString())
        }
    }

    return
}