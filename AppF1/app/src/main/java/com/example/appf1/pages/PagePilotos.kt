package com.example.appf1.pages

import PaginaPilotosVM
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.components.SliderComponent
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceContainerLight
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.repository.PilotosRepository
import com.example.appf1.repository.PilotosRepositoryMemory

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
    pilotId: String
) {
    val vm: PaginaPilotosVM = viewModel()
    LaunchedEffect(pilotId) {
        vm.loadPilot(pilotId)
    }
    val driver = vm.selectedPilot.collectAsState().value
    if (driver == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Cargando...")
        }
    } else {
        val sliderItems = vm.uiState.collectAsState().value.map { pilotoUI ->
            val piloto = vm.getPilotoById(pilotoUI.id)
            CardSliderDetails(
                id = pilotoUI.id,
                imgId = piloto?.imgId ?: R.drawable.piloto,
                imgDesc = pilotoUI.name,
                title = pilotoUI.name
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
                        painter = painterResource(driver.imgId),
                        contentDescription = "Foto de ${driver.name}",
                        modifier = Modifier.size(180.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(R.string.object_name) + " : ${driver.name}",
                        color = onSurfaceLight
                    )
                    Text(
                        text = stringResource(R.string.team_name) + " : ${driver.team.name}",
                        color = onSurfaceLight
                    )
                    Text(
                        text = stringResource(R.string.victories_name) + " : ${driver.wins}",
                        color = onSurfaceLight
                    )
                    Text(
                        text = stringResource(R.string.podium_name) + " : ${driver.podiums}",
                        color = onSurfaceLight
                    )
                    Text(
                        text = stringResource(R.string.polepos_name) + " : ${driver.poles}",
                        color = onSurfaceLight
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // SliderComponent esto luego se cambia por las carreras que gano.
            SliderComponent(
                cardsInfo = sliderItems,
                onCardClick = { card ->
                    val selectedPiloto = vm.getPilotoById(card.id)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun pagePreviewP() {
    val driver = PilotoDTO(
        id = "1",
        name = "Piloto 1",
        team = EquipoDTO(
            id = "5",
            name = "Equipo 2",
            drivers = emptyList(),
            championships = 1,
            wins = 1,
            podiums = 5,
            imgId = R.drawable.mercedes
        ),
        wins = 6,
        podiums = 3,
        poles = 7,
        imgId = R.drawable.sainz
    )

}
