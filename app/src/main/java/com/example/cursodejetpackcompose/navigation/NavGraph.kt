package com.example.cursodejetpackcompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cursodejetpackcompose.screens.PantallaDetalle
import com.example.cursodejetpackcompose.screens.PantallaInicio


@Composable
fun NavGraph(navController: NavHostController,
             padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "pantallaInicio",
        modifier = Modifier.padding(padding)
    ) {
        composable(
            route = "pantallaInicio"
        ) {
            PantallaInicio(navController)
        }
        composable(
            route = "pantallaDetalle"
        ) {
            PantallaDetalle()
        }


    }
}
