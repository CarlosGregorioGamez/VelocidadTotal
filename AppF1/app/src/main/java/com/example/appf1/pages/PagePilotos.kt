package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.compose.onPrimaryLight
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceContainerLight

/**
 * Página para ver los datos en detalle de un piloto en específico
 *
 * @param nombrePiloto
 * @param apellidos
 * @param equipo
 * @param carrerasCorridas nº de carrera en las que participo
 * @param victorias
 * @param podios
 * @param poles
 */
@Composable
fun pagePilotos(
    nombrePiloto: String,
    apellidos: String,
    equipo: String,
    carrerasCorridas: Int,
    victorias: Int,
    podios: Int,
    poles: Int
) {

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

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,        // centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // centra horizontalmente
    ){
        Card(
            modifier = Modifier
                .padding(24.dp)
                .height(400.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = surfaceContainerLight
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.piloto),
                    contentDescription = "Foto de $nombrePiloto",
                    modifier = Modifier.size(180.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringResource(id = R.string.object_name) + " : $nombrePiloto", modifier = Modifier, onSurfaceLight)
                Text(text = stringResource(id = R.string.second_name) + " : $apellidos", modifier = Modifier, onSurfaceLight)
                Text(text = stringResource(id = R.string.team_name) + " : $equipo", modifier = Modifier, onSurfaceLight)
                Text(text = stringResource(id = R.string.race_name) + " : $carrerasCorridas", modifier = Modifier, onSurfaceLight)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringResource(id = R.string.victories_name) + " : $victorias", modifier = Modifier, onSurfaceLight)
                Text(text = stringResource(id = R.string.podium_name) + " : $podios", modifier = Modifier, onSurfaceLight)
                Text(text = stringResource(id = R.string.polepos_name) + " : $poles", modifier = Modifier, onSurfaceLight)

                Spacer(modifier = Modifier.height(16.dp))


            }
        }
        SliderComponent(sliderList)

    }
}

@Preview
@Composable
fun pagePreviewP() {
    pagePilotos("Piloto 1", "ni idea", "alguno", 6, 3, 7, 2)
}