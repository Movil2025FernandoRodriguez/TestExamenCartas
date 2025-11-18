package net.iessochoa.fernandorodriguez.testexamencartas.Componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.fernandorodriguez.testexamencartas.ui.theme.TestExamenCartasTheme

/*
Variables necesarias
    var currentRating by remember { mutableIntStateOf(0) }
    val onRatingChange: (Int) -> Unit = {currentRating = it}
 */


@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    onRatingChanged: (Int) -> Unit,
    iconSelect: ImageVector = Icons.Filled.Star,
    iconUnSelect: ImageVector = Icons.Outlined.Star,
    modifier: Modifier = Modifier,
    color: Color = Color.Red
) {
    // 1. Aplica el modifier del parámetro al componente raíz (el Row)
    Row(modifier = modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) iconSelect else iconUnSelect,
                contentDescription = "Star $i",
                // 2. Crea un Modifier nuevo y local para cada Icon
                modifier = Modifier.clickable {
                    onRatingChanged(
                        if (i == 1 && currentRating == 1) 0 else i
                    )
                },
                tint = if (i <= currentRating) color else Color.Unspecified
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun rattingBarPreview(){

    var currentRating by remember { mutableIntStateOf(0) }
    val onRatingChange: (Int) -> Unit = {currentRating = it}

    TestExamenCartasTheme {
        RatingBar(5, currentRating, onRatingChange)
    }

}