package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                TimePickerWithDialog()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TimePickerWithDialog() {
        val timePickerState = rememberTimePickerState(
            initialHour = 12,
            initialMinute = 10,
            is24Hour = false
        )
        var showDialog by remember { mutableStateOf(false) }
        var selectedTimeText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (selectedTimeText.isEmpty()) "Seleccionar una hora"
                else "Hora seleccionada: $selectedTimeText"
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { showDialog = true }) {
                Text(text = "Abrir TimePickerDialog")
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text(text = "Selecciona una hora")
                },
                confirmButton = {
                    TextButton(onClick = {
                        val hour = timePickerState.hour
                        val minute = timePickerState.minute
                        val amPm = if (hour < 12) "AM" else "PM"
                        val hour12 = when {
                            hour == 0 -> 12
                            hour > 12 -> hour - 12
                            else -> hour
                        }
                        selectedTimeText = String.format(
                            Locale.getDefault(),
                            "%02d:%02d %s", hour12, minute, amPm
                        )
                        showDialog = false
                    }) {
                        Text(text = "Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialog = false
                    }) {
                        Text(text = "Cancelar")
                    }
                },
                text = {
                    TimePicker(
                        state = timePickerState,
                        layoutType = TimePickerLayoutType.Vertical,
                        colors = TimePickerDefaults.colors()
                    )
                }
            )
        }
    }
}
/* El problema principal es que se mezclan dos mundos de Android, 1 el Android tradicional o nativo, este
* usa como android.app.TimePickerDialog
* 2. JetpackCompose, usa funciones @composables como TimePicker y AlertDialog
*
* El profesor enseño a usar TimePickerDialog que es una clase de Android Nativo.Pero todo el codigo
*  se contruye con JetPack Compose
* 3. Compose no tiene un TimePickerDialog oficial  que funcione como la clase nativa, se usa AlertDialog que es el
* cuadro flotante con botones, y se coloco TimePicker dentro de AlertDialog, así todo se mantuvo en ecosistema
*    de Jetpack Compose
* En resumen ,el problema es una incompatibilidad entre librerias. la forma de crear un dialogo
* con un selector es diferente en Jetpack Compose que en Android tradicional*/