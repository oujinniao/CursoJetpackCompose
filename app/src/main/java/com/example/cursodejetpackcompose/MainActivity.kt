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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
                DeterminateProgressCircularIndicator()
            }
        }
    }

    //FuncionircularProgressIndicator Determinado, simulando una descarga de datos
    //0f -1f
    //0f es 0.0 decimal float %0 de progreso
    //1f es 100.0 decimal float %1 de progreso
    //ej. 0.5f es 50.0 decimal float %50 de progreso
    //ej 0.05f es 5.0 decimal float %5 de progreso
    //ej 0.95f es 95.0 decimal float %95 de progreso


    @Composable
    fun DeterminateProgressCircularIndicator() {
        var progress by remember { mutableStateOf(0f) }
        var startDownload by remember { mutableStateOf(false) }

        LaunchedEffect(startDownload) {
            if (startDownload) {
                repeat(20) {  //repite 20 veces
                    delay(150)// espera 150 milisegundos
                    progress += 0.02f //aumenta en cada repeticion un 2%
                }
                progress = 1f
                startDownload = false
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
                text = "Descargando...",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(80.dp),
                strokeWidth = 10.dp,
                color = if
                                (progress < 1f)
                    MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondary

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    startDownload = true
                },
                enabled = progress < 1f && !startDownload
            ) {
                Text(
                    if (progress < 1f) "Descargando..."
                    else "Iniciar Descarga"
                )


            }
            if (progress >= 1f) {


                Spacer(modifier = Modifier.height(16.dp))


                Button(
                    onClick = {
                        progress = 0f
                        startDownload = false

                    }

                ) {
                    Text(
                        text = "Reiniciar Descarga"
                    )

                }
            }
        }
    }
}







    @Composable
    fun IndeterminateCircularProgressIndicator() {
        var isLoading by remember { mutableStateOf(false) }
        var startOperation by remember { mutableStateOf(false) }

        LaunchedEffect(startOperation) {
            if (startOperation) {
                simulateSlowProcess(
                    onStar = { isLoading = true },
                    onFinish = {
                        isLoading = false
                        startOperation = false
                    }
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
            .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (isLoading) { //si loading es true, ejecutamos este bloque de codigos
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Procesando operación...",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )

            } else { //si loading es false, ejecutamos este bloque de codigos


                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "OPERACION EXITOSA",
                    modifier = Modifier.size(64.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Operacion COMPLETADA",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    startOperation = true
                }
            ) {
                Text(text = "Iniciar Operación!!!")
            }

        }
    }



    suspend fun simulateSlowProcess(
        onStar:()->Unit,
        onFinish:()->Unit
    ){
        onStar()
        delay(3000)
        onFinish()

    }

