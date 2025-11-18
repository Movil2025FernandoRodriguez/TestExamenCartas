package net.iessochoa.fernandorodriguez.testexamencartas.Componentes

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iessochoa.fernandorodriguez.testexamencartas.ui.theme.TestExamenCartasTheme
import org.w3c.dom.Text


@Composable
fun topTittleCartas(){

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Comprobador de cartas",
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        )
    }


}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun tittlePreview(){

    TestExamenCartasTheme {

        topTittleCartas()

    }

}