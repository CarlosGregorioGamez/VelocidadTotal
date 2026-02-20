package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.appf1.components.TitleComponent
import com.example.appf1.repository.RetrofitPilotosRepository
import com.example.appf1.viewmodel.vm.PaginaPilotosVM

/**
 * Página para ver los datos en detalle de un piloto en específico
 * @param pilotId Recoge el id del piloto para identificarlo
 */


@Composable
fun pagePilotos(
    pilotId: String,
    repository: RetrofitPilotosRepository,
    onRaceClick: (String) -> Unit
) {
    val vm = remember { PaginaPilotosVM(repository) }

    LaunchedEffect(pilotId) {
        vm.loadPilot(pilotId)
    }

    val driver by vm.selectedPilot.collectAsState()
    val top3Races by vm.top3Races.collectAsState()

    if (driver == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Cargando...")
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Imagen piloto
        Image(
            painter = painterResource(driver!!.imgId),
            contentDescription = driver!!.name,
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        TitleComponent("Carreras en el top 3")

        Spacer(modifier = Modifier.height(16.dp))

        if (top3Races.isEmpty()) {

            Text(
                text = "Este piloto no tiene apariciones en el top 3",
                textAlign = TextAlign.Center
            )

        } else {

            val sliderItems = top3Races.map { carrera ->
                CardSliderDetails(
                    id = carrera.id,
                    imgId = carrera.imgId,
                    imgDesc = carrera.name,
                    title = carrera.name
                )
            }

            SliderComponent(
                cardsInfo = sliderItems,
                onCardClick = { card ->
                    onRaceClick(card.id)
                }
            )
        }
    }
}