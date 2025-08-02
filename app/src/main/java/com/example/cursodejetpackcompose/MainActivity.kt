package com.example.cursodejetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.cursodejetpackcompose.ui.theme.CursoDeJetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoDeJetpackComposeTheme {
                //MyConstraintLayout()
                //MyLazyColumn()
                //MyLazyRowImagenes()
                //MyLazyRowImagenesWeb()
                //MyLazyVerticalGrid()
                //GaleriaDeFotos()
                //MyLazyHorizontalGrid()
                //Mycard()
                //MyElevatedCard()
                MyOutlinedCard()



            }
        }
    }

    @Composable
    fun MyOutlinedCard() {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(14.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        )
        {
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {

                Text(text="Titulo de la tarjeta",
                    style= MaterialTheme.typography.titleMedium,
                color=MaterialTheme.colorScheme.primary)

                Spacer(modifier=Modifier.height(8.dp))
                Text(
                    text="esta tarjeta tiene mas info de la funcion",
                    style=MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier=Modifier.height(8.dp))

                Button(
                    onClick={},
                    modifier=Modifier.align(Alignment.End)
                    ){
                    Text(text="Ver mas")

                }
                }



        }
    }


    @Composable
    fun MyElevatedCard() {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(14.dp),
            shape = RoundedCornerShape(15.dp),
        )
        {
            Column(
                modifier=Modifier
                    .padding(16.dp)

            ) {
                Text(
                    text="Titulo de la tarjeta",
                    style= MaterialTheme.typography.titleMedium)
                Spacer(modifier=Modifier.height(8.dp))

                Text(
                    text="Ejemplo de ElevatedCard",
                    style=MaterialTheme.typography.bodyMedium
                )
            }

        }


    }






    @Composable
    fun Mycard(){
        Card(
            modifier= Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant),
        ) {

            Column (
                modifier= Modifier
                    .padding(16.dp)

            ){
                Image(
                    painter = painterResource(id = R.drawable.mi_imagen),
                    contentDescription = "Mi imagen",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(15.dp)),

                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Mi imagen",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Mi descripcion",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                 Button(
                    onClick = {  },
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )


                    ){
                        Text(text = "Ver mas")

                    }
            }
        }
    }
}








    @Composable
    fun MyLazyHorizontalGrid() {
        val myElementos = List(20){
            "Elemento ${it+2}"
        }
        LazyHorizontalGrid (

            rows = GridCells.Adaptive(100.dp),//ancho variable de alto
            //rows = GridCells.Fixed(4),//ancho fijo de 4 columnas
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ){
            items(myElementos){myElemento->
                GridItemHorizontal(element = myElemento)
            }
        }

    }
    @Composable
    fun GridItemHorizontal(element: String) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .border(2.dp,
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(15.dp)
                ),//definimos la forma del borde

        contentAlignment = Alignment.Center,
        ) {
            Text(text = element,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp),
                )
        }
    }




    @Composable
    fun MyLazyVerticalGrid() {
        val myElementos = List(20){
            "Elemento ${it+1}"
             }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),//ancho fijo de 2 columnas

            //columns = GridCells.Adaptive(100.dp), ancho variable de 100dp
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(myElementos){myElemento->
                GridItem(element = myElemento)
            }
        }

    }






    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun GaleriaDeFotos(
        urls: List<String> = listOf(
            "https://cdn.pixabay.com/photo/2025/04/30/13/05/cat-9569386_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/05/01/08/33/building-5115897_1280.jpg",
            "https://cdn.pixabay.com/photo/2025/07/20/13/12/little-red-riding-hood-9724469_1280.jpg",
            "https://cdn.pixabay.com/photo/2025/06/01/16/05/mountains-9700000_1280.jpg",
            "https://cdn.pixabay.com/photo/2025/03/15/10/45/dog-9622222_1280.jpg"
        )
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(urls) { url ->
                AsyncImage(
                    model = url,
                    contentDescription = "Imagen remota",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }


@Composable
fun GridItem(element: String) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(
                MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(15.dp)
            )
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Icono",
                modifier = Modifier.size(50.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(
                modifier = Modifier.height(8.dp))

                Text(text = element, fontWeight = FontWeight.Bold)



        }
    }

}



    @Composable
    fun MyLazyRowImagenesWeb(){

        val imagenesUrl=listOf(
            "https://cdn.pixabay.com/photo/2025/04/30/13/05/cat-9569386_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/05/01/08/33/building-5115897_1280.jpg",
            "https://cdn.pixabay.com/photo/2025/07/20/13/12/little-red-riding-hood-9724469_1280.jpg"
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
         items(imagenesUrl){imagenUrl->
             AsyncImage(
                 model = imagenUrl,
                 contentDescription = "Mi imagen de la Url",
                 modifier=Modifier
                     .size(180.dp)
                     .clip(RoundedCornerShape(15.dp)),
                 contentScale = ContentScale.Crop
             )

         }
        }
    }

    @Composable
    fun MyLazyRowImagenes(){

        val listImage = listOf(
            R.drawable.conejo,
            R.drawable.perro,
            R.drawable.conejo,
            R.drawable.zorro,
            R.drawable.conejo,
            R.drawable.zorro,
            R.drawable.conejo,
            R.drawable.zorro,

            )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(listImage){image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Mi imagen animal",
                    modifier = Modifier
                        .size(100.dp)
                        //.clip(CircleShape))
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )


    }


    //@Composable
    //fun MyLazyRow() {
      //  val Elementos = listOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4")
        //LazyRow(
          //  modifier = Modifier
            //    .fillMaxWidth()
              //  .padding(16.dp),
            //horizontalArrangement = Arrangement.spacedBy(16.dp)

        //) {

          //  items(Elementos) { elementos ->
            //    Text(
              //      text = elementos,
                //    modifier = Modifier
                  //      .padding(10.dp)
                    //    .background(MaterialTheme.colorScheme.primary)
                      //  .padding(16.dp),
                    //color = Color.White,
                    //fontSize = 20.sp,
                    //style = MaterialTheme.typography.bodyMedium
               // )



                @Composable
                fun MyLazyColumn() {

                    val elementos = List(100) { "Elemento No $it" }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                            .padding(16.dp)


                    ) {
                        item {
                            Text(
                                text = "Encabezado de la lista",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 20.sp
                            )
                        }


                        items(elementos) { item ->
                            Text(
                                text = item,
                                fontSize = 20.sp
                            )

                        }

                        item {
                            Text(
                                text = "Pie de la lista",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 20.sp
                            )
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
        }



