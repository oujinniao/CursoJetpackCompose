package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                ModalBottomSheetExample()

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ModalBottomSheetExample(){
       val sheetState = rememberModalBottomSheetState(
           skipPartiallyExpanded = true
       )
        var showSheet by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center

        ){
            Button(
                onClick = { showSheet = true }
            ) {
                Text(text = "Mostrar Bottom Sheet")

            }
        }
        if (showSheet){
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.surface,
               shape = MaterialTheme.shapes.large,
                scrimColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)

            ){
                Column(
                    modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    Text(text = "Contenido del Bottom Sheet")
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { showSheet = false }) {
                        Text(text = "Cerrar")
                    }
                }
            }
            }



//ModalBottomSheet sirve para mostrar contenido de manera temporal
// ideal cuando queremos que el usuario realice una accion rapida y vuelva al contenido anterior





    }

}








