package com.example.appf1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R


class CardDetails(var imgId: Int, var imgDesc: String = "", var title: String)

/**
 * Componente por defecto para las tarjetas
 *
 * @param cardInfo recibe datos de CardDetails para definir el contenido de cada tarjeta
 */
@Composable
fun CardComponent(cardInfo: CardDetails) {
    Card(
        modifier = Modifier
            .width(width = 250.dp)
            .height(height = 125.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cardInfo.imgId),
                contentDescription = cardInfo.imgDesc,
                modifier = Modifier.padding(6.dp)
            )
            TitleComponent(
                title = "Ejemplo de titulo",
                textStyle = MaterialTheme.typography.titleSmall,
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Preview
@Composable
fun CardComponentPreview() {
    CardComponent(
        cardInfo = CardDetails(
            imgId = R.drawable.ic_launcher_foreground,
            imgDesc = "Descripcion",
            title = "Titulo de ejemplo"
        )
    )
}