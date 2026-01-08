package com.example.appf1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R


class CardSliderDetails(var imgId: Int, var imgDesc: String = "", var title: String)

/**
 * Componente por defecto para las tarjetas
 *
 * @param cardSliderInfo recibe datos de CardDetails para definir el contenido de cada tarjeta
 */
@Composable
fun SliderCardComponent(cardSliderInfo: CardSliderDetails) {
    Card(
        modifier = Modifier
            .padding(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = cardSliderInfo.imgId),
                contentDescription = cardSliderInfo.imgDesc,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(100.dp)
                .aspectRatio(1f / 1f)
            )
            TitleComponent(
                title = cardSliderInfo.title,
                textStyle = MaterialTheme.typography.titleSmall,
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Preview
@Composable
fun CardSliderComponentPreview() {
    SliderCardComponent(
        cardSliderInfo = CardSliderDetails(
            imgId = R.drawable.f1simple,
            imgDesc = "Descripcion",
            title = "Titulo de ejemplo"
        )
    )
}