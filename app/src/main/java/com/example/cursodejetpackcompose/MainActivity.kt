package com.example.cursodejetpackcompose


import MiTextoReciclado
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                Componentes()
            }
        }
    }


    @Composable
    fun Componentes() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Red)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 15.dp,
                trackColor = Color.Green,

            )
            Spacer(modifier = Modifier.height(56.dp))
            LinearProgressIndicator(
                modifier=Modifier.fillMaxWidth(),
                color=MaterialTheme.colorScheme.primary,
                trackColor=Color.Cyan,


                )




            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = MaterialTheme.colorScheme.secondary,
                strokeWidth = 30.dp,
                trackColor = Color.Gray,
            )



        }
    }
}

@Composable
fun MyOutlinedButton(){
    OutlinedButton(
        onClick = { },
              colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onPrimary),
        shape=RoundedCornerShape(15.dp),
        border= BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .shadow(4.dp, shape=RoundedCornerShape(15.dp))
            .padding(16.dp)

        ){
        Icon(Icons.Default.Favorite,
            contentDescription = "Favoritos",
            modifier =Modifier.size(25.dp))
        Text(text="Favoritos")

    }


}

@Composable
fun MyTextButton(){
    TextButton(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary



    )
    ){
        Text(text="Texto Boton")
    }


}

@Composable
    fun MyImage(){
    Image(
        painter= painterResource(id=R.drawable.mi_imagen),
        contentDescription="Mi imagen",
        modifier=Modifier
            .size(200.dp)
            .padding(16.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Red, CircleShape),
            contentScale = ContentScale.Crop,

            alignment = Alignment.BottomEnd,
                )

}

@Composable
fun MyIcon(){
    Icon(
        imageVector = Icons.Default.Person,
        contentDescription = "Icono",

        modifier = Modifier.size(50.dp),
        tint=MaterialTheme.colorScheme.primary
    )

}
