package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.appf1.viewmodel.vm.PaginaCarrerasVM
import com.example.compose.onPrimaryLight
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceContainerLight

/**
 * Página para ver los datos en detalle de una carrera en específico
 *
 * @param carreraId Recoge el id de la carrera para identificar su informacion
 **/

@Composable
fun pageCarreras(
    carreraId: String,
    onRaceClick: (String) -> Unit
) {
    val vm: PaginaCarrerasVM = viewModel()
    LaunchedEffect(carreraId) {
        vm.loadCarrera(carreraId)
    }
    val race = vm.selectedRace.collectAsState().value
    if (race == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Cargando...")
        }
    } else {
        val sliderCarrerasItem = vm.uiState.collectAsState().value.map { carreraUI ->
            val carrera = vm.getCarreraById(carreraUI.id)
            CardSliderDetails(
                id = carreraUI.id,
                imgId = carrera?.imgId ?: R.drawable.vegas,
                imgDesc = carreraUI.name,
                title = carreraUI.name
            )
        }
        Box(
            contentAlignment = Alignment.Center
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
                            painter = painterResource(R.drawable.vegas),
                            contentDescription = "Imagen del circuito"
                        )
                        Text(
                            text = stringResource(R.string.race_name) + " : ${race.name}",
                            color = onSurfaceLight
                        )
                        Text(
                            text = stringResource(R.string.editions_name) + " : ${race.editions}",
                            color = onSurfaceLight
                        )
                        Text(
                            text = stringResource(R.string.country_name) + " : ${race.country}",
                            color = onSurfaceLight
                        )
                        Text(
                            text = stringResource(R.string.victories_name) + " : ${race.winner}",
                            color = onSurfaceLight
                        )
                        Text(
                            text = stringResource(R.string.podium_name) + " : ${race.podium}",
                            color = onSurfaceLight
                        )
                        Text(
                            text = stringResource(R.string.lenght_name) + " : ${race.length}",
                            color = onSurfaceLight
                        )
                    }
                }
                SliderComponent(
                    cardsInfo = sliderCarrerasItem,
                    onCardClick = { card ->
                        onRaceClick(card.id)
                    }
                )

            }
        }
    }
}