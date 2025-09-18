package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

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
    var isExpanded by remember { mutableStateOf(false) }

    val items = listOf("Inicio", "Buscar", "Perfil", "Favoritos", "Ajustes") // lista de etiquetas
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.Person,
        Icons.Default.Favorite,
        Icons.Default.Settings
    ) // lista de iconos

    var selectedItem by rememberSaveable { mutableStateOf(0) } // variable que almacena la posicion del item seleccionado


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


        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    println("Boton flotante pulsado")
                    isExpanded = !isExpanded
                },
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Enviar"
                    )
                },
                text = {
                    Text(text = "Enviar mensaje")
                },
                expanded = isExpanded,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(16.dp),
                elevation = FloatingActionButtonDefaults.elevation(
                    6.dp,
                    pressedElevation = 12.dp
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        content = { paddingValues ->   //contenido de la pantalla
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),


            ) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(start = 8.dp),
                    header = {
                        Image(

                        painter =rememberAsyncImagePainter("https://assets.puzzlefactory.com/puzzle/292/153/original.jpg"),
                            //painter = painterResource(id = R.drawable.avatar),
                            contentDescription = "Avatar del usuario",
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .size(48.dp)
                                .clip(CircleShape)
                        )
                    }

                ) {
                    items.forEachIndexed { index, label ->
                        NavigationRailItem(
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = label
                                )
                            },
                            label = { Text(text = label) },
                            alwaysShowLabel = false,
                            enabled = true
                        )
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(start = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "pantalla: ${items[selectedItem]}",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
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