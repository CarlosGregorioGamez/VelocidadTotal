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
 * @param piloto1
 * @param piloto2
 */
@Composable
fun team(name: String, piloto1: String, piloto2: String) {

    val backgroundColor = Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .border(1.dp, color =  Color.Black)
            .padding(all = 4.dp)

    ) {
        Column {
            Text(text = name, modifier = Modifier.fillMaxWidth())
            Text(text = piloto1, modifier = Modifier.fillMaxWidth())
            Text(text = piloto2, modifier = Modifier.fillMaxWidth())
        }

    }
}

@Preview
@Composable

fun teamPreview() {
    team("Barcelona","399", "aaaaa")
}

@Preview
@Composable
fun pruebateamPreview() {
    team("marte","13","marvin")
}

