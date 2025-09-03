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
            DatosUsuarioScreen()

            }
        }
    }

    suspend fun obtenerDatosAPI(): String { //suspend fun se ejecuta dentro de una corrutina(corutina se ejecuta de manera asincrona)
        delay(5000)
        return "Hola"
    }
    @Composable
    fun DatosUsuarioScreen() {
        var usuario by remember{ mutableStateOf<String?>(null)}

        var isloading by remember{ mutableStateOf(true)}



        LaunchedEffect(Unit) {
            usuario = obtenerDatosAPI()
            isloading = false

        }
        Column (
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            if(isloading){
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary

                )
            }else{
                usuario?.let {
                    Text(
                        text ="En hora buena: $it",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,

                        )
                }
            }
        }

    }
}





