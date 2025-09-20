package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    TabRowExample()
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TabRowExample(){
        val tabTitles = listOf("Inicio", "Favoritos", "Perfil")
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val interactionSource = remember {
            List(tabTitles.size) { MutableInteractionSource() }

             }

        val tabIcons = listOf(
            Icons.Default.Home,
            Icons.Default.Favorite,
            Icons.Default.Person
        )

        Scaffold (
            topBar = {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.statusBarsPadding(),
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                                .height(3.dp),
                            color = MaterialTheme.colorScheme.primary

                        )
                    },
                    divider = {
                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant,
                            thickness = 1.dp
                        )
                    }
                ) {
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            modifier = Modifier.padding(horizontal = 4.dp),
                            enabled = true,
                            text = {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.labelLarge

                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = tabIcons[index],
                                    contentDescription = title
                                )
                            },
                            selectedContentColor = MaterialTheme.colorScheme.primary,
                            unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            interactionSource = interactionSource[index]
                        )
                    }
                }
            }
        ){ paddingValues ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ){
                when (selectedTabIndex) {
                    0 -> Text("pantalla de Inicio", style = MaterialTheme.typography.bodyLarge)
                    1 -> Text("pantalla Favoritos", style = MaterialTheme.typography.bodyLarge)
                    2 -> Text(" Pantalla Perfil", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }

    }
}


