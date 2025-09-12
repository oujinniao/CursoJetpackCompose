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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
              DatePickerExemple()

            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DatePickerExemple() {
        val zoneId = ZoneId.systemDefault() //obtenemos la zona horaria local del dispositivo
        val currentDate = LocalDate.now(zoneId) //obtenemos la fecha actual sin la hora local

        var starOfDayMillis = currentDate
            .atStartOfDay(zoneId)//obtenemos la fecha actual con hora 00:00:00 2025-04-15
            //-05:00[AMerica/Lima]

            .toInstant()//convierte el zonedatetime a formato UTC: 2025-04-15T00:00:00Z
            //T00 separador de la fecha y la hora
            //05:00Z zona horaria de lima en formato UTC
            //UTC tiempo universal coordinado, cuenta el tiempo en numeros
            .toEpochMilli()//Epoch milisegundos desde 1970 al momento actual

        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = starOfDayMillis)
        var selectedDateText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            DatePicker(
                state = datePickerState,
                showModeToggle = true,
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        text = "Selecciona una fecha",
                        style = MaterialTheme.typography.titleLarge

                    )
                },
                headline = {
                    Text(
                        text = "Selecciona una fecha",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val selectedDateMillis = datePickerState.selectedDateMillis
                    if (selectedDateMillis != null) {

                        val daysSinceEpoch = selectedDateMillis / (24 * 60 * 60 * 1000)
                        //24 horas * 60 minutos * 60 segundos * 1000 milisegundos=84.400.000 milisegundos por dia
                      val localDate= LocalDate.ofEpochDay(daysSinceEpoch)
                        val dateString = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        selectedDateText = dateString
                    }
                }
            ) {
                Text(text = "Seleccionar fecha")
            }
            Spacer(modifier = Modifier.height(16.dp))

            if (selectedDateText.isNotEmpty()) {
                Text(
                    text = "Fecha seleccionada: $selectedDateText",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}











