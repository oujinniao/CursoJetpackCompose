package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
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
                ProduceStateExample()
            }
        }
    }

    @Composable
    fun ProduceStateExample(){


        val datos: State<String> = produceState(initialValue = "Cargando..."){
            delay(5000)
            value = "Datos cargados, éxito"
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = datos.value)
        }
    }
}






//la funcion produceState es una funcion de alto nivel que nos permite crear un estado
//que se actualizan de forma asíncrona a medida que cambian los valores
//de la fuente de datos.
//produceState recibe dos parámetros:
//initialValue: T, que es el valor inicial del estado.
//producer: suspend () -> T, que es una función suspendida que devuelve un valor de tipo T.
//Esta función se ejecuta en un hilo separado y actualiza el estado con el valor devuelto.
//La función produceState devuelve un State<T> que contiene el valor actual del estado.
//El estado se actualiza automáticamente cuando el valor devuelto por la función producer cambia.
//UNA VEZ QUE EL COMPOSABLE QUE LA USA SALE DE LA PANTALLA, LA CORRUTINA INTERNA SE CANCELA AUTOMÁTICAMENTE



