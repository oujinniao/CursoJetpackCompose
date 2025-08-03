package com.example.cursodejetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import java.util.UUID


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                //RememberExample()
                //RememberSaveableExample()
                //rememberMutableStateOfExample()
                //MyScreen()
                //MyScreen2()
                //CounterScreen()
                //MyDerivedState()
                //MyMutableStateListOf()
                //CounterCicleDeVida()
                ListaDeTareasScreen()

            }
        }
    }

    data class Tarea(val id: String, val descripcion: String)

    fun ListaInicialDeTareas(): List<Tarea> {

        return listOf(
            Tarea(id = UUID.randomUUID().toString(), descripcion = "Tarea 1"),
            Tarea(id = UUID.randomUUID().toString(), descripcion = "Tarea 2"),
            Tarea(id = UUID.randomUUID().toString(), descripcion = "Tarea 3"),
            Tarea(id = UUID.randomUUID().toString(), descripcion = "Tarea 4"),
            Tarea(id = UUID.randomUUID().toString(), descripcion = "Tarea 5")
        )
    }

    @Composable
    fun ListaDeTareasScreen() {

        var tareas by remember { mutableStateOf(ListaInicialDeTareas()) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    tareas = tareas + Tarea(
                        id = UUID.randomUUID().toString(),
                        descripcion = "nueva tarea"
                    )
                },
                modifier = Modifier.height(36.dp)
            ) {

                Text(text = "Agregar tarea")

            }
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(tareas, key = { it.id }) { tarea ->

                    TareaItem(
                        tarea = tarea,
                        onEliminar = {tareaEliminar ->
                        tareas = tareas.filter { it.id != tareaEliminar.id }
                    }
                    )

                }

            }

        }

    }

    @Composable
    fun TareaItem(tarea: Tarea, onEliminar: (Tarea) -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            colors =  CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            shape = RoundedCornerShape(12.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween


            ){
                Text(

                    text =tarea.descripcion,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)

                )
                IconButton(
                    onClick = {onEliminar(tarea)}


                ){

                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar tarea"

                    )

                }
            }

        }
    }
}









