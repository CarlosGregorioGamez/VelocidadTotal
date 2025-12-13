package com.example.appf1.components


import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Componente que identifica las carreras para listar
 *
 * @param name
 * @param editions
 */

data class Track(
    val name: String,
    val editions: Int,
    val country: String,
    val winner: Driver,
    val podium: List<Driver>,
    val lenght: Double
)

@Composable
fun race(track: Track) {

    val backgroundColor = Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .border(1.dp, color = Color.Black)
            .padding(all = 4.dp)

    ) {
        Column {
            Text(text = track.name, modifier = Modifier.fillMaxWidth())
            Text(text = track.editions.toString(), modifier = Modifier.fillMaxWidth())
        }

    }
}

@Preview
@Composable

fun carreraPreview() {
    race(
        Track(
            name = "Barcelona",
            editions = 46,
            country = TODO(),
            winner = TODO(),
            podium = TODO(),
            lenght = TODO()
        )
    )
}

@Preview
@Composable
fun pruebaCarrerasPreview() {
    race(Track(
        name = TODO(),
        editions = TODO(),
        country = TODO(),
        winner = TODO(),
        podium = TODO(),
        lenght = TODO()
    ))
}