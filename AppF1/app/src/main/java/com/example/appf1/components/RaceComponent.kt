package com.example.appf1.components


import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

/**
 * Componente que identifica las carreras para listar
 *
 * @param carrera Recibe la data class CarreraDTO
 */


@Composable
fun race(carrera: CarreraDTO) {

    val backgroundColor = Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .border(1.dp, color = Color.Black)
            .padding(all = 4.dp)

    ) {
        Column {
            Box(
                modifier = Modifier.padding(5.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(carrera.imgId),
                    contentDescription = carrera.name
                )
            }

            Text(text = carrera.name, modifier = Modifier.fillMaxWidth())
            Text(text = carrera.editions.toString(), modifier = Modifier.fillMaxWidth())
            Text(text = carrera.country, modifier = Modifier.fillMaxWidth())
            Text(text = carrera.winner, modifier = Modifier.fillMaxWidth())
            Text(text = carrera.podium.toString(), modifier = Modifier.fillMaxWidth())
            Text(text = carrera.length.toString() + "km", modifier = Modifier.fillMaxWidth())

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
            winner = "",
            podium = emptyList(),
            length = 4.5,
            imgId = R.drawable.italia,
        )
    )
}

