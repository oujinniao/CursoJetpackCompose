package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import kotlinx.coroutines.delay


data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                FrasesRandom()
            }
        }
    }
}




@Composable
fun FrasesRandom() {
    var refreshTrigger by remember { mutableIntStateOf(0) }
    val frases by produceState<String?>(
        initialValue = null,
        key1 = refreshTrigger
        ){

        delay(1000)

        value = listOf(
            "El éxito no es la clave de la felicidad. La felicidad es la clave del éxito. Si amas lo que haces, tendrás éxito.",
            "El único modo de hacer un gran trabajo es amar lo que haces.",
            "La única forma de hacer un gran trabajo es amar lo que haces.",
            "El éxito es la suma de pequeños esfuerzos repetidos día tras día.",
            "No hay caminos para la paz; la paz es el camino"
        ).random()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (frases == null) {
            CircularProgressIndicator()
        } else {
            Text(
                text = frases!!,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 30.sp,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(16.dp),
                fontFamily = FontFamily.SansSerif
            )

        }
            OutlinedButton(
                onClick = {
                    refreshTrigger++
                },
                modifier = Modifier.padding(top=32.dp)
            ) {
                Text(
                    text = "Pulsa para ver otra frase",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(16.dp),
                    fontFamily = FontFamily.SansSerif
                )

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



