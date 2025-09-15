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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                IndeterminateLinearProgressIndicator()

            }
        }
    }



//Linea indeterminada, soloindicar que la operacion esta en curso

    @Composable
    fun IndeterminateLinearProgressIndicator() {
        var isLoading by remember { mutableStateOf(true) }
        var isCompleted by remember { mutableStateOf(false) }

        LaunchedEffect(isLoading) { // si Loading es true
            if (isLoading) {
                delay(5000)
                isLoading = false
                isCompleted = true

            }
        }
        Column(modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            if (isLoading) { // si loading es true
                Text(
                    "Procesando datos",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.secondary,
                    //progress = 0.5f,
                    //strokeWidth = 8.dp,
                    strokeCap = androidx.compose.ui.graphics.StrokeCap.Round,

                    )
            }else if (isCompleted) {
                Text(
                    "Datos procesados",
                    style = MaterialTheme.typography.titleMedium )

                Spacer(modifier = Modifier.height(24.dp))

            }
            Button(
                onClick = {
                    isLoading = true
                    isCompleted = false
                }, enabled = !isCompleted
            ) {
                Text("Procesando datos")
            }


        }

    }

}











