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
import com.example.appf1.model.CarreraDTO
import com.example.appf1.model.PilotoDTO

/**
 * Componente que identifica las carreras para listar
 *
 * @param track Recibe la data class CarreraDTO
 */



@Composable
fun race(track: CarreraDTO) {

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
            Text(text = track.country, modifier = Modifier.fillMaxWidth())
            Text(text = track.winner.toString(), modifier = Modifier.fillMaxWidth())
            Text(text = track.podium.toString(), modifier = Modifier.fillMaxWidth())
            Text(text = track.lenght.toString() + "km", modifier = Modifier.fillMaxWidth())
        }

    }
}

@Preview
@Composable

fun carreraPreview() {
    race(
        CarreraDTO(
            id = "4",
            name = "Barcelona",
            editions = 46,
            country = "España",
            winner = PilotoDTO("1", "Fernando Alonso", "Aston Martin"),
            podium = emptyList(),
            lenght = 4.5,
        )
    )
}

