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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                //MyScreen()
                //CounterLaunchedEffect()
                RememberCoroutineScope()


            }
        }
    }
    @Composable
    fun RememberCoroutineScope() {
        val scope = rememberCoroutineScope()

        var text by remember {mutableStateOf("Picha aquí")}

            Column(
                modifier= Modifier
                .fillMaxSize()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.headlineMedium)


                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        scope.launch {
                            text = "Presionado"
                            delay(3000)
                            text = "FIN TAREA"
                        }
                    }
                ) {
                    Text(text = "Ejecutar tarea")
                }
            }


            }

    }


