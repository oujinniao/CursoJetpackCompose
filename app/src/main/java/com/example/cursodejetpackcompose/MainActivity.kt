package com.example.cursodejetpackcompose


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
               DisposableEffectExample()


            }
        }

    }

    @Composable
    fun DisposableEffectExample() {
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            DisposableEffect(key1 = Unit){
             Log.d("DisposableEffect", "Comenzando el DisposableEffect")

               onDispose {
                   Log.d("DisposableEffect", "Deteniendo el DisposableEffect")
               }

                }
            Text(
                text = "Componente con DisposableEffect",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp),
                )
            }
            }
        }
//DisposableEffect tiene dos parámetros: key1 y effect.
//y su funcion principal es borrar los efectos al salir de la pantalla


