package com.example.cursodejetpackcompose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cursodejetpackcompose.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    val navController = rememberNavController() //creamos el controlador de navegación

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Mi aplicación") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ){paddingValues->
        NavGraph(navController= navController, padding = paddingValues)

    }




}