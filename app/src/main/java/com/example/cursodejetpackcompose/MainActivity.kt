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
                DeterminateLinearProgressIndicator()

            }
        }
    }



//Linea indeterminada, soloindicar que la operacion esta en curso

    @Composable
    fun DeterminateLinearProgressIndicator() {
        var progress by remember { mutableStateOf(0f) }//0% se inicializa

        var isDownLoading by remember { mutableStateOf(false) }

        var downloadCompleted by remember { mutableStateOf(false) }

        LaunchedEffect(isDownLoading) {
            if (isDownLoading) {
                downloadCompleted = false
                while (progress < 1f) { //1f = 100%
                     delay(50)//aqui esperamos 5 milisegundos
                    progress += 0.05f    //aumentamos el progreso en 5%
                }
               isDownLoading = false
                downloadCompleted = true

            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Downloading...de archivo",
                style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(16.dp))

            if(isDownLoading){
                LinearProgressIndicator(
                    progress =progress,
                       modifier = Modifier
                           .fillMaxWidth()
                        .height(8.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "%.1f".format(progress * 100) + "%",
                style = MaterialTheme.typography.bodyLarge)
            }
            Button(
                onClick = {
                    if (!isDownLoading) {
                        progress = 0f
                        isDownLoading = true
                    }
                },
                enabled = !isDownLoading

            ){
                Text(
                    text = "Iniciar Descarga")
           }
         if(downloadCompleted){
             Spacer(modifier = Modifier.height(16.dp))
             Text(
                 text = "Descarga completada",
                 style = MaterialTheme.typography.bodyLarge,
                 color = MaterialTheme.colorScheme.primary

             )
         }


        }

    }

}










