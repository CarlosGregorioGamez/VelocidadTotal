package com.example.appf1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R

@Composable
fun SliderComponent(
    cardsInfo: List<CardSliderDetails>,
    onCardClick: (CardSliderDetails) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cardsInfo) { card ->
            onCardClick(card)
        }
    }
}



@Preview
@Composable
fun SliderComponentPreview() {
    val sliderList = listOf(
        CardSliderDetails(
            imgId = R.drawable.f1simple,
            title = "Ejemplo 1"
        ),
        CardSliderDetails(
            imgId = R.drawable.calendario_carreras,
            title = "Ejemplo 2"
        ),
        CardSliderDetails(
            imgId = R.drawable.perfil,
            title = "Ejemplo 3"
        )
    )

    SliderComponent(
        cardsInfo = sliderList,
        onCardClick = {

        }
    )
}