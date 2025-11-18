package net.iessochoa.fernandorodriguez.testexamencartas.data

import androidx.compose.runtime.Composable
import net.iessochoa.fernandorodriguez.testexamencartas.R
import net.iessochoa.fernandorodriguez.testexamencartas.model.MagicCard

@Composable
fun getMagicCardList(): List<MagicCard>{

    return listOf(
        MagicCard(
            nombre = "Carta 1",
            imagen = R.drawable.carta1
        ),
        MagicCard(
            nombre = "Carta 2",
            imagen = R.drawable.carta2
        ),
        MagicCard(
            nombre = "Carta 3",
            imagen = R.drawable.carta3
        ),
        MagicCard(
            nombre = "Carta 4",
            imagen = R.drawable.carta4
        ),
        MagicCard(
            nombre = "Carta 5",
            imagen = R.drawable.carta5
        )
    )


}