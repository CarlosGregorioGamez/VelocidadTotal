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
 * Componente que identifica los equipos para listar
 *
 * @param name
 * @param drivers lista de pilotos que conforman el equipo
 * @param championships
 * @param wins
 * @param podiums
 */

data class Constructor(
    val name: String,
    val drivers: List<Driver>,
    val championships: Int,
    val wins: Int,
    val podiums: Int
)

@Composable
fun team(constructor: Constructor) {

    val backgroundColor = Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .border(1.dp, color = Color.Black)
            .padding(all = 4.dp)

    ) {
        Column {
            Text(text = constructor.name, modifier = Modifier.fillMaxWidth())
            Text(text = constructor.drivers[0].toString(), modifier = Modifier.fillMaxWidth())
            Text(text = constructor.drivers[1].toString(), modifier = Modifier.fillMaxWidth())
            Text(text = constructor.championships.toString(), modifier = Modifier.fillMaxWidth())
            Text(text = constructor.wins.toString(), modifier = Modifier.fillMaxWidth())
            Text(text = constructor.podiums.toString(), modifier = Modifier.fillMaxWidth())
        }

    }
}

@Preview
@Composable

fun teamPreview() {
    team(
        Constructor(
            name = TODO(),
            drivers = TODO(),
            championships = TODO(),
            wins = TODO(),
            podiums = TODO()
        )
    )
}

@Preview
@Composable
fun pruebateamPreview() {
    team(
        Constructor(
            name = TODO(),
            drivers = TODO(),
            championships = TODO(),
            wins = TODO(),
            podiums = TODO()
        )
    )
}

