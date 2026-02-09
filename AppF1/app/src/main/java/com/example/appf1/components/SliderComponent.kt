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
            SliderCardComponent(
                cardSliderInfo = card,
                onClick = { onCardClick(card) }
            )
        }
    }
}




@Preview
@Composable
fun SliderComponentPreview() {
    val sliderList = listOf(
        CardSliderDetails(
            id = TODO(),
            imgId = TODO(),
            imgDesc = TODO(),
            title = TODO()
        ),
        CardSliderDetails(
            id = TODO(),
            imgId = TODO(),
            imgDesc = TODO(),
            title = TODO()
        ),
        CardSliderDetails(
            id = TODO(),
            imgId = TODO(),
            imgDesc = TODO(),
            title = TODO()
        )
    )

    SliderComponent(
        cardsInfo = sliderList,
        onCardClick = {

        }
    )
}