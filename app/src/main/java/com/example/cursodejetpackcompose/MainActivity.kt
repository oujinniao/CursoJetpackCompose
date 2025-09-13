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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                TimePickerExample()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TimePickerExample() {
        val timePickerState = rememberTimePickerState(
            initialHour = 12,
            initialMinute = 10,
            is24Hour = false
        )
        var selectedTimeText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (selectedTimeText.isNotEmpty()) {
                    "La hora seleccionada es: $selectedTimeText"
                } else {
                    "Seleccione una hora"
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TimePicker(
                state = timePickerState,
                layoutType = TimePickerLayoutType.Vertical,
                colors = TimePickerDefaults.colors() // Esta es la línea que soluciona el problema
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val hour24 = timePickerState.hour
                    val minute = timePickerState.minute

                    val amPm = if (timePickerState.hour < 12) "AM" else "PM"
                    val hour12 = when {
                        timePickerState.hour == 0 -> 12
                        timePickerState.hour < 13 -> timePickerState.hour
                        else -> timePickerState.hour - 12
                    }

                    selectedTimeText = String.format("%02d:%02d %s", hour12, minute, amPm)
                }
            ) {
                Text(text = "Seleccionar hora o confirmar")
            }
        }
    }
}