package com.example.cursodejetpackcompose


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {

                rememberUpdateState()

            }
        }

    }

    @Composable
    fun rememberUpdateState() {
        var message by remember { mutableStateOf(" Saludos desde JDC") }

        val context = LocalContext.current
        val currentMessage by rememberUpdatedState(newValue = message)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    message = "Mensaje actualizado"
                },
                modifier = Modifier.padding(6.dp)
            ) {
                Text(text = "Mostrar mensaje actualizado")
            }
                LaunchedEffect(Unit) {
                    delay(5000)
                    Toast.makeText(context, currentMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }





//rememberUpdateSate es una funcion que se encarga de actualizar el estado de una variable
//se usa para actualizar el estado de una variable que se usa en una funcion componible
//como LaunchedEffect, SideEffect, DisposableEffect y produceState.
//LocalContex.current es una variable que se usa para obtener el contexto de la aplicacion



