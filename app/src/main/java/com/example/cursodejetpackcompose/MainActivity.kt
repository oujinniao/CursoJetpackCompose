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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL


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
                ProduceStateApiCallExample()
            }
        }
    }
}


@Composable
fun ProduceStateApiCallExample() {

    val todoState: State<Todo?> = produceState<Todo?>(initialValue = null) {

        withContext(Dispatchers.IO) {
            try {

                val url = URL("https://jsonplaceholder.typicode.com/todos/1")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                val reader = connection.inputStream.bufferedReader()
                val jsonResponse = reader.readText()


                val title = jsonResponse.split("\"title\": \"")[1].split("\",")[0]
                val completedString = jsonResponse.split("\"completed\": ")[1].split("}")[0]
                val completed = completedString.toBoolean()


                value = Todo(userId = 1, id = 1, title = title, completed = completed)

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        todoState.value?.let { todo ->
            Text(text = "Título de la tarea:")
            Text(text = todo.title)
            Text(text = "Completada: ${if (todo.completed) "Sí" else "No"}")
        } ?: run {

            CircularProgressIndicator()
            Text(text = "Cargando datos...")
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



