package net.iessochoa.fernandorodriguez.testexamencartas.Componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.testexamencartas.model.MagicCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(
    modifier : Modifier = Modifier,
    cartas: List<MagicCard>, // Esto es la lista de cartas
    selectedValue: String, // Esto es el mutable que hay elevado en estado
    label: String,
    onValueChanged: (String) -> Unit
)
{

    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded, // Le decimos si esta expandido o no
        onExpandedChange = { isExpanded = !isExpanded }, // Cuando cambia, su estado es el contrario de como estaba
        modifier = modifier // Le pasamos el modifier del parámetro
    ) {
        OutlinedTextField(
            readOnly = true, // Solo de lectura
            value = selectedValue, // Este es el valor que va a tomar la caja
            onValueChange = { }, // Al ser solo lectura, aqui no va nada
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            }, // Icono piramide invertida
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable, true) // Anclamos el menú al textField
                .fillMaxWidth()
        )

        // Esto es el menu desplegable
        ExposedDropdownMenu( // Esto es lo que va a hacer que se muestren las opciones al desplegar la caja
            expanded = isExpanded, // Se le dice si esta desplegado o no
            onDismissRequest = { isExpanded = false }
        ) {
            cartas.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.nombre) },
                    onClick = {
                        onValueChanged(option.nombre)// ➜ Avisamos al padre
                        isExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CustomDropDownMenu(
    options: List<MagicCard>,
    seleccion: String,
    label: String,
    onValueChanged: (String) -> Unit
){

    Column (modifier = Modifier.padding(16.dp)) {

        DropDown(
            cartas = options,
            selectedValue = seleccion,
            label = label,
            onValueChanged = onValueChanged
        )

    }


}