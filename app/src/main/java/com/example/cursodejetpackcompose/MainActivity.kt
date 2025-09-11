package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                AlertDialogExample()
            }
        }
    }

    @Composable
    fun AlertDialogExample() {
        var showDialog by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Mostrar diálogo")
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.alerta),
                        tint = Color.Unspecified,
                        contentDescription = "!!!Alerta!!"
                    )
                },

                title = {
                    Text(
                        text = "¿estas seguro?"
                    )
                },
                text = {
                    Text(
                        text = "Esta accion no se puede cancelar.\n ¿desea continuar?",
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp),
                       maxLines = 2,
                        fontSize = 12.sp,

                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                        }

                    ) {
                        Text("Aceptar")
                    }

                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                }

            )
        }
    }
}








