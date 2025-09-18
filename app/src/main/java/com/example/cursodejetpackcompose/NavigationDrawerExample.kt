package com.example.cursodejetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerExample() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val drawerItems = listOf("Inicio", "Perfil", "Ajustes")
    val drawerIcons = listOf(Icons.Default.Home, Icons.Default.Person, Icons.Default.Settings)
    var selectedItem by rememberSaveable { mutableStateOf(0) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    drawerItems,
                    drawerIcons,
                    selectedItem,
                    onItemClick = { index ->
                        selectedItem = index
                        scope.launch { drawerState.close() }
                    }
                )
            }
        },
        drawerState = drawerState,
        gesturesEnabled = true
    ) {
        MainScaffold(
            selectedSection = drawerItems[selectedItem],
            onMenuClick = {
                scope.launch { drawerState.open() }
            }
        )
    }
}


