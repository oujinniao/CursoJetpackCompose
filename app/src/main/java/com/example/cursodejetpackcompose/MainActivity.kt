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
                IndeterminateCircularProgressIndicator()
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

    }
