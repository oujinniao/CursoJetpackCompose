package com.example.cursodejetpackcompose

import MiTextoReciclado
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme


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
                TextFieldExample()

            }
        }
    }
    @Composable
    fun TextFieldExample(){

        var text by remember { mutableStateOf("") }
        var isError =text.length>=10

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
       ){
            TextField(
                value = text,
                onValueChange = {
                    text = it},
                label = { MiTextoReciclado(text = "Nombre") },
                 placeholder = { Text(text = "Escribe tu nombre") },
                leadingIcon = {
                    Icon(Icons.Default.Warning,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.primary)

                },
                trailingIcon = {
                    if(isError){
                        Icon(Icons.Default.Warning
                            , contentDescription = "Error",
                            tint = MaterialTheme.colorScheme.error)
                    }
                    },

                isError = isError,
                singleLine = true,
                maxLines = 1,
                minLines = 1,
                readOnly = false,
                enabled = true,
                keyboardOptions = KeyboardOptions(

                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = androidx.compose.ui.text.input.ImeAction.Done,
                    capitalization = androidx.compose.ui.text.input.KeyboardCapitalization.Words),
                modifier = Modifier.fillMaxWidth(),
            )
            if(isError){
                Text(
                text = "El nombre no puede tener mas de 10 caracteres",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp, top= 5.dp),)
            }


        }
    }

}












