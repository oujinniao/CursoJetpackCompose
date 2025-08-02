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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
                //RememberSaveableExample()
                //rememberMutableStateOfExample()
                //MyScreen()
                MyScreen2()

            }
        }
    }
}

@Composable
fun MyScreen2(){
    var isChecked by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Checkbox: ${if(isChecked) "Activado" else "Desactivado"}")

        Spacer(modifier = Modifier.height(8.dp))

        MySwitch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }

        )//actualiza el estado
    }

    }
    @Composable
    fun MySwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,//Activado

                uncheckedThumbColor = MaterialTheme.colorScheme.onSurface//Desactivado
            )
        )

    }




//este componente es el padre y text guardara el estado
@Composable
fun MyScreen (){
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Hijo
        MyOutlinedTextField(text = text, onTextChange = {text = it})

    }

}
@Composable
fun MyOutlinedTextField(text: String, onTextChange: (String) -> Unit){

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = "Label") },
        modifier=Modifier.fillMaxWidth()
    )

}
