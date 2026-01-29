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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.Driver
import com.example.appf1.components.SliderComponent
import com.example.appf1.viewmodel.vm.PaginaPilotosVM
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceContainerLight
import androidx.compose.runtime.collectAsState

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
   driver: Driver,
   vm: PaginaPilotosVM = viewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,        // centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // centra horizontalmente
    ) {
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
                    contentDescription = "Foto de ${driver.name}",
                    modifier = Modifier.size(180.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(id = R.string.object_name) + " : ${driver.name}",
                    modifier = Modifier,
                    onSurfaceLight
                )
                Text(
                    text = stringResource(id = R.string.second_name) + " : ${driver.surname}",
                    modifier = Modifier,
                    onSurfaceLight
                )
                Text(
                    text = stringResource(id = R.string.team_name) + " : ${driver.team}",
                    modifier = Modifier,
                    onSurfaceLight
                )
                Text(
                    text = stringResource(id = R.string.race_name) + " : ${driver.wins}",
                    modifier = Modifier,
                    onSurfaceLight
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(id = R.string.victories_name) + " : ${driver.wins}",
                    modifier = Modifier,
                    onSurfaceLight
                )
                Text(
                    text = stringResource(id = R.string.podium_name) + " : ${driver.podiums}",
                    modifier = Modifier,
                    onSurfaceLight
                )
                Text(
                    text = stringResource(id = R.string.polepos_name) + " : ${driver.poles}",
                    modifier = Modifier,
                    onSurfaceLight
                )
            }
        }
        SliderComponent(
            vm.uiState.collectAsState().value.map { pilotoUI -> CardSliderDetails(1, pilotoUI.imageDesc, pilotoUI.title) },
            onCardClick = {

            }
        )
    }
}

@Preview
@Composable
fun pagePreviewP() {
    pagePilotos(driver = Driver("Piloto 1", "Apellido 1", "ni idea", 6, 3, 7))
}