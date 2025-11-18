package net.iessochoa.fernandorodriguez.testexamencartas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import net.iessochoa.fernandorodriguez.testexamencartas.Componentes.CustomDropDownMenu
import net.iessochoa.fernandorodriguez.testexamencartas.Componentes.RatingBar
import net.iessochoa.fernandorodriguez.testexamencartas.Componentes.mostrarImagen
import net.iessochoa.fernandorodriguez.testexamencartas.Componentes.topTittleCartas
import net.iessochoa.fernandorodriguez.testexamencartas.data.getMagicCardList
import net.iessochoa.fernandorodriguez.testexamencartas.ui.theme.TestExamenCartasTheme


@Composable
fun mainScreen(){

    val cardList = getMagicCardList()
    var seleccion by remember { mutableStateOf(cardList[0].nombre) }
    // var onSelection : (String) -> Unit = {seleccion = it}

    var currentRating by remember { mutableIntStateOf(0) }
    val onRatingChange: (Int) -> Unit = {currentRating = it}

    val onSelection: (String) -> Unit = { nuevaCarta ->
        seleccion = nuevaCarta
        currentRating = 0   // 🔥 Reinicia las estrellas
    }

    val tipoMensaje = mostrarMensaje(seleccion, currentRating)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val mapaCartas = mapOf(
        "Carta 1" to R.drawable.carta1,
        "Carta 2" to R.drawable.carta2,
        "Carta 3" to R.drawable.carta3,
        "Carta 4" to R.drawable.carta4,
        "Carta 5" to R.drawable.carta5,
    )

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {topTittleCartas() },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    // Muestra el mensaje en el Snackbar
                    snackbarHostState.showSnackbar(
                        message = tipoMensaje,
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Icon( imageVector = Icons.Filled.Favorite, contentDescription = "Mostrar Snackbar")
            }
        }

        ) { innerPadding ->

        Column (modifier = Modifier
            .padding(innerPadding)) {

            CustomDropDownMenu(
                options = cardList,
                seleccion = seleccion,
                label = "Cartas disponibles",
                onValueChanged = onSelection
            )

            Spacer(modifier = Modifier
                .padding(20.dp))

            mostrarImagen(
                opcion = seleccion,
                mapa = mapaCartas
            )
            Spacer(modifier = Modifier
                .padding(20.dp))

            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Califica el estado de la carta"
                )
                RatingBar(5, currentRating, onRatingChange)

            }

        }

    }

}


private fun mostrarMensaje(
    nombreCarta: String,
    estado: Int
): String{

    var mensaje = ""

    if (nombreCarta.isBlank()){
        mensaje = "Por favor, selecciona una carta antes de continuar."
    }else if (estado < 3 ){
        mensaje = "$nombreCarta calificada como muy desgastada"
    } else if (estado == 3 ){
        mensaje = "$nombreCarta calificada como desgastada"
    } else {
        mensaje = "$nombreCarta calificada como nueva"
    }

    return mensaje
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun mainScreenPreview(){

    TestExamenCartasTheme {
        mainScreen()
    }

}