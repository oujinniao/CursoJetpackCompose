package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    PaddingScaffoldExample()
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PaddingScaffoldExample() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Ejemplo con y sin padding")
                            },
                    colors =  TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Black,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White
                    )
                )

            }
        ){paddingValues ->
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp)
            ){
                Text(text = "Contenido de la pantalla", color= Color.Black)
                Text(text = "Contenido de la pantalla", color= Color.Black)
                Text(text = "Contenido de la pantalla", color= Color.Black)
                Text(text = "Contenido de la pantalla", color= Color.Black)
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(paddingValues)
            ){
                Text(text = "Contenido de la pantalla", color= Color.Black)
                Text(text = "Contenido de la pantalla", color= Color.Black)
                Text(text = "Contenido de la pantalla", color= Color.Black)
            }

                 }
    }
}


