package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                    ScaffoldScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Mi Aplicación")
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /*accion de busqueda*/ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notificaciones"
                        )
                    }
                    IconButton(
                        onClick = { /*accion de carrito*/ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Configuración"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            // Barra inferior
            BottomAppBar(
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favoritos"
                        )
                    }
                },
                tonalElevation = 5.dp,
                windowInsets = WindowInsets.navigationBars,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 12.dp,
                    hoveredElevation = 15.dp,
                    focusedElevation = 20.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        content = { paddingValues ->   //contenido de la pantalla
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Contenido de la pantalla",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldScreenPreview() {
    MaterialTheme {
        ScaffoldScreen()
    }
}