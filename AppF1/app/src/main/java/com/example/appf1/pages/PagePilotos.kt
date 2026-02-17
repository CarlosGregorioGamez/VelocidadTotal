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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.appf1.components.TitleComponent
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.repository.PilotosRepository
import com.example.appf1.repository.PilotosRepositoryMemory

/**
 * Página para ver los datos en detalle de un piloto en específico
 * @param pilotId Recoge el id del piloto para identificarlo
 */


@Composable
fun pagePilotos(
    pilotId: String,
    onRaceClick: (String) -> Unit
) {
    val vm: PaginaPilotosVM = viewModel()

    LaunchedEffect(pilotId) {
        vm.loadPilot(pilotId)
    }

    val driver by vm.selectedPilot.collectAsState()

    if (driver == null) {
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
    } else {
        val sliderPilotoItem = vm.uiState.collectAsState().value.map { pilotoUI ->
            val carrera = vm.getPilotoById(pilotoUI.id)
            CardSliderDetails(
                id = pilotoUI.id,
                imgId = carrera?.imgId ?: R.drawable.williams,
                imgDesc = pilotoUI.name,
                title = pilotoUI.name
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(driver!!.imgId),
                    contentDescription = driver!!.name,
                    modifier = Modifier.size(180.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // SliderComponent esto luego se cambia por las carreras que gano.
                SliderComponent(
                    cardsInfo = sliderPilotoItem,
                    onCardClick = { card ->
                        vm.loadPilot(card.id)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        TitleComponent("Carreras puntuadas")

        Spacer(modifier = Modifier.height(40.dp))

        SliderComponent(
            cardsInfo = sliderItems,
            onCardClick = { card ->
                onRaceClick(card.id)
            }
        )
    }
}