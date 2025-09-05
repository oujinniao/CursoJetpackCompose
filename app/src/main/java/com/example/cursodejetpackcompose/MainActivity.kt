package com.example.cursodejetpackcompose


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                //MyScreen()
                //CounterLaunchedEffect()
                //CounterRememberUpdatedState()
                CoroutineScopeExample()


            }
        }

        }

    suspend fun slowTask(){
        Log.d("MainActivity", "Slow task started")
        delay(5000)
        Log.d("MainActivity", "Slow task finished")

    }
    @Composable
    fun CoroutineScopeExample(){

        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .fillMaxSize()
            .padding(16.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Button(onClick = {
                scope.launch {
                    slowTask()
                }
            }) {
                Text(text = "Start Slow Task")
            }
        }
    }
}

