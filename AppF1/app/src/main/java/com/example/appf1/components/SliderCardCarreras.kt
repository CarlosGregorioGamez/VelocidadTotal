package com.example.appf1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

@Composable
fun SliderCardCarreras(carrera: CarreraDTO) {
    Card(
        modifier = Modifier
            .padding(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = carrera.imgId),
                contentDescription = carrera.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(125.dp)
                    .aspectRatio(1.5f / 1f)
            )
            TitleComponent(
                title = carrera.name,
                textStyle = MaterialTheme.typography.titleSmall,
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun CardSliderCarrerasPreview() {
    SliderCardCarreras(
        carrera = CarreraDTO(
            id = "1",
            name = "GP de Italia",
            editions = 3,
            country = "Italia",
            winner = PilotoDTO(
                "ooo",
                "aaa",
                EquipoDTO(
                    id = "4",
                    name = "Equipo5",
                    drivers = emptyList(),
                    championships = 0,
                    wins = 5,
                    podiums = 9,
                    imgId = R.drawable.aston_martin,
                ),
                imgId = R.drawable.alonso
            ),
            podium = emptyList(),
            lenght = 5.6,
            imgId = R.drawable.italia,
        )
    )
}