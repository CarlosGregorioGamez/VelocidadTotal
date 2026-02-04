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
import com.example.appf1.R
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

/**
 * Componente que identifica los pilotos para listar
 *
 * @param name
 * @param team
 * @param wins
 * @param podiums
 */


@Composable
fun pilot(driver: PilotoDTO) {

    val backgroundColor = Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .border(1.dp, color = Color.Black)
            .padding(all = 4.dp)

    ) {
        Column() {
            Text(text = driver.name, modifier = Modifier.fillMaxWidth())
            Text(text = driver.team.name, modifier = Modifier.fillMaxWidth())
        }

    }
}

@Preview
@Composable

fun pilotoPreview() {
    pilot(
        driver = PilotoDTO(
            id = "1",
            name = "Paco",
            team = EquipoDTO(
                "1",
                "ge",
                emptyList(),
                1,
                4,
                24,
                R.drawable.mercedes
            ),
            wins = 2,
            podiums = 7,
            imgId = R.drawable.albon
        )
    )
}

@Preview
@Composable
fun pruebasPreview() {
    pilot(
        driver = PilotoDTO(
            id = "1",
            name = "Paco",
            team = EquipoDTO(
                "1",
                "ge",
                emptyList(),
                1,
                4,
                24,
                R.drawable.mercedes
            ),
            wins = 2,
            podiums = 7,
            imgId = R.drawable.albon
        )
    )
}



