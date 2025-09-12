package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                DatePickerDialogExample()

            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DatePickerDialogExample() {
        val zoneId = ZoneId.systemDefault()
        val currentDate = LocalDate.now(zoneId)
        val startOfDayMillis = currentDate
            .atStartOfDay(zoneId)
            .toInstant()
            .toEpochMilli()

        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = startOfDayMillis)
        var selectedDateText by remember { mutableStateOf("") }

        var showDialog by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { showDialog = true }
            ) {
                Text("Selecciona una fecha")

            }
            Spacer(modifier = Modifier.padding(16.dp))

            if (selectedDateText.isNotEmpty()) {
                Text(
                    "Fecha seleccionada: $selectedDateText",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            if (showDialog) {
                DatePickerDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                val selectedDateMillis = datePickerState.selectedDateMillis
                                if (selectedDateMillis != null) {
                                    val daysSinceEpoch = selectedDateMillis / (24 * 60 * 60 * 1000)
                                    val localDate = LocalDate.ofEpochDay(daysSinceEpoch)
                                    val dateString =
                                        localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                    selectedDateText = dateString
                                }
                                showDialog = false

                            }
                        ) {
                            Text("Confirmar")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showDialog = false
                            }
                        ) {
                            Text("Cancelar")
                        }
                    }

                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = true,
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp),
                        title = {
                            Text(
                                text = "Titulo de DatePicker",
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = Modifier.padding(8.dp)
                            )
                        },
                        headline = {
                            Text(
                                text = "Selecciona una fecha",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                    )
                }
            }

        }

    }
}












