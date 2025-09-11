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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {

            SwitchExample()
            }
        }
    }

    @Composable
    fun SwitchExample(){
        var wifiEnable by remember { mutableStateOf(false) }

        Column (
            modifier=Modifier.fillMaxSize()
            .padding(16.dp),

            verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

        ){
            Row (
                modifier= Modifier
                    .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween


            ){
                Column (
                    modifier=Modifier.weight(1f)

                ){
                    Text(
                        text="Wifi",
                        style= MaterialTheme.typography.titleMedium,
                    )
        Spacer(modifier=Modifier.height(8.dp))
                    Text(
                        text= if (wifiEnable)"Conectado a la red" else "Desconectado de la red",
                        style= MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant

                    )
                Switch(
                    checked = wifiEnable,
                    onCheckedChange = {wifiEnable=it},
                    thumbContent = {
                        if (wifiEnable){
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Activado",
                               modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Green

                            )
                        }else{
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Desactivado",
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                                tint = Color.Red.copy(alpha = 0.6f)
                            )
                        }
                        },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = Color.Green.copy(alpha = 0.6f),
                        uncheckedThumbColor = MaterialTheme.colorScheme.surfaceVariant,
                        uncheckedTrackColor = Color.Red.copy(alpha = 0.6f)
                    )
                )

                }
            }

        }


    }

}