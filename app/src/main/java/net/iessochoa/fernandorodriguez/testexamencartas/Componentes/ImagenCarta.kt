package net.iessochoa.fernandorodriguez.testexamencartas.Componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.testexamencartas.model.MagicCard


@Composable
fun mostrarImagen(
    opcion: String,
    mapa: Map<String, Int>
){
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Image(modifier = Modifier
        .width(300.dp)
        .height(300.dp),
        painter = painterResource(mapa.get(opcion)!!),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
    }


}