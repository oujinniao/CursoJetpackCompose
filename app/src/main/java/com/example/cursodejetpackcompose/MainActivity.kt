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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
                //RememberExample()
                RememberSaveableExample()

            }
        }
    }
}

@Composable
fun RememberSaveableExample(){
    var myName by rememberSaveable { mutableStateOf("") }
    Column(
        modifier= Modifier
            .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text(
            text="Ingresa tu nombre y luego gira la pantalla",
            style=MaterialTheme.typography.titleLarge
            )
        Spacer(modifier=Modifier.height(8.dp))

        OutlinedTextField(
            value=myName,
            onValueChange={myName=it},
            label={Text(text="Ingresa tu nombre")},
            modifier=Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(8.dp))

        Button(
            onClick = {myName=""}
        ){
            Text(text="Limpiar")
        }

    }


}


@Composable
fun RememberExample(){
    var count by remember { mutableIntStateOf(10) }//creamos el estado inicializando en cero
Column(
    modifier=Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally

){
    Text(
        text="Contador : $count",
        style= MaterialTheme.typography.bodyMedium
    )
    Spacer(modifier=Modifier.height(16.dp))

    Button(
        onClick={count++}

    ){
        Text(text="Incrementar")
    }

}

}


