package com.example.cursodejetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                //MyConstraintLayout()
                MyLazyColumn()
            }
        }
    }

@Composable
fun MyLazyColumn(){

val elementos = List(100){"Elemento No $it"}

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)


    ){
        items(elementos){
            item ->
            Text(text = item,
                fontSize=20.sp)
            Text(text = item,
                fontSize=20.sp)
            Text(text = item,
                fontSize=20.sp)
            Text(text = item,
                fontSize=20.sp)
        }
    }


}


    @Composable
    fun MyConstraintLayout() {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            val (image, name, description, button) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Mi perfil de imagen",
                modifier = Modifier
                    .size(100.dp)
                    .padding(16.dp)

                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)

                    },
                contentScale = ContentScale.Crop,

                )
            Text(
                text = "Mi nombre es",
                modifier = Modifier
                    .constrainAs(name) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, margin = 16.dp)
                }
            )
            Text(
                text = "Mi descripcion",
                style = MaterialTheme.typography.bodyMedium,
                     modifier = Modifier
                    .constrainAs(description) {
                    top.linkTo(name.bottom, margin = 4.dp)
                    start.linkTo(name.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints

                }
            )
            Button(
                onClick = { },
                modifier = Modifier
                    .constrainAs(button) {
                    top.linkTo(description.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                        end.linkTo(parent.end)
                }
            ) {
                Text(text = "Mi boton")
            }
        }
    }


    @Composable
    fun MyOutlinedButton() {
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .shadow(4.dp, shape = RoundedCornerShape(15.dp))
                .padding(16.dp)

        ) {
            Icon(
                Icons.Default.Favorite,
                contentDescription = "Favoritos",
                modifier = Modifier.size(25.dp)
            )
            Text(text = "Favoritos")

        }


    }

    @Composable
    fun MyTextButton() {
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary


            )
        ) {
            Text(text = "Texto Boton")
        }


    }

    @Composable
    fun MyImage() {
        Image(
            painter = painterResource(id = R.drawable.mi_imagen),
            contentDescription = "Mi imagen",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Red, CircleShape),
            contentScale = ContentScale.Crop,

            alignment = Alignment.BottomEnd,
        )

    }

    @Composable
    fun MyIcon() {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Icono",

            modifier = Modifier.size(50.dp),
            tint = MaterialTheme.colorScheme.primary
        )

    }
}
