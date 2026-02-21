package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.appf1.repository.EquipoRepository
import com.example.appf1.repository.RetrofitEquiposRepository
import com.example.appf1.viewmodel.vm.PaginaEquiposVM
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceContainerLight

/**
 * Página para ver los datos en detalle de un piloto en específico
 *
 * @param equipoId Recoge el id del equipo para identificar su informacion
 **/


@Composable
fun pageEquipos(
    equipoId: String,
    onPilotClick: (String) -> Unit,
    repository: RetrofitEquiposRepository
) {
    val vm = remember { PaginaEquiposVM(repository) }

    LaunchedEffect(equipoId) {
        vm.loadEquipos(equipoId)
    }
    val team = vm.selectedTeam.collectAsState().value
    if (team == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Cargando...")
        }
    } else {
        val pilotosEquipo = vm.getPilotosByTeam(team.id)
        val nombresPilotos = pilotosEquipo.joinToString(", ") { it.name }
        val sliderPilotos = pilotosEquipo.map { piloto ->
            CardSliderDetails(
                id = piloto.id,
                imgId = piloto.imgId,
                imgDesc = piloto.name,
                title = piloto.name
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
                        painter = painterResource(id = team.imgId),
                        contentDescription = "Logo ${team.name}",
                        modifier = Modifier.size(180.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(R.string.team_name) + " : ${team.name}",
                        color = onSurfaceLight
                    )
                    Text(
                        text = stringResource(R.string.team_drivers) + " : $nombresPilotos",
                        color = onSurfaceLight
                    )

                    Text(
                        text = stringResource(R.string.team_championship) + " : ${team.championships}",
                        color = onSurfaceLight
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(R.string.team_wins) + " : ${team.wins}",
                        color = onSurfaceLight
                    )
                    Text(
                        text = stringResource(R.string.team_podiums) + " : ${team.podiums}",
                        color = onSurfaceLight
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                pilotosEquipo.forEach { piloto ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            onPilotClick(piloto.id)
                        }
                    ) {
                        Image(
                            painter = painterResource(piloto.imgId),
                            contentDescription = piloto.name,
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Fit
                        )

                        Text(
                            text = piloto.name
                        )
                    }
                }
            }

        }
    }
}