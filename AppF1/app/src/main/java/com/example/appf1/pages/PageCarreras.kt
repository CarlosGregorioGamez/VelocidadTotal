package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.appf1.components.TitleComponent
import com.example.appf1.repository.CarreraRepository
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.repository.PilotosRepository
import com.example.appf1.repository.RetrofitCarrerasRepository
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
    repository: RetrofitCarrerasRepository,
    onPilotClick: (String) -> Unit
) {
    val vm= remember { PaginaCarrerasVM(repository) }

    LaunchedEffect(carreraId) {
        vm.loadCarrera(carreraId)
    }

    val race = vm.selectedRace.collectAsState().value

    if (race == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            Text("Cargando...")
        }
        return
    }

    val pilotosBase = MainListRepositoryMemory.pilotosBase

    val pilotosCarreraIds = listOf(race.winner) + race.podium

    val pilotosCarrera = pilotosCarreraIds.mapNotNull { pilotosBase[it] }

    val sliderPilotos = pilotosCarrera.map { piloto ->
        CardSliderDetails(
            id = piloto.id,
            imgId = piloto.imgId,
            imgDesc = piloto.name,
            title = piloto.name
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = surfaceContainerLight
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(race.imgId),
                    contentDescription = race.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.height(16.dp))

                val winnerName = pilotosBase[race.winner]?.name ?: race.winner
                val podiumNames = race.podium.mapNotNull { pilotosBase[it]?.name }

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

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Ganador: $winnerName",
                    color = onSurfaceLight
                )

                Text(
                    text = "Podio: ${podiumNames.joinToString(", ")}",
                    color = onSurfaceLight
                )

                Text(
                    text = stringResource(R.string.lenght_name) + " : ${race.length}",
                    color = onSurfaceLight
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        TitleComponent("Top 3 pilotos en esta carrera")

        Spacer(modifier = Modifier.height(40.dp))
            SliderComponent(
                cardsInfo = sliderPilotos,
                onCardClick = { card ->
                    onPilotClick(card.id)
                }
            )
        }
}
