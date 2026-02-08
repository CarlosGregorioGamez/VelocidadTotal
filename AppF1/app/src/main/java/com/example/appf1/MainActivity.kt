package com.example.appf1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.pages.pagePilotos
import com.example.appf1.viewmodel.vm.MainListVM
import com.example.appf1.viewmodel.vm.ListType

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppF1ThemeMinimal {

                // Piloto de ejemplo (normalmente vendría de navegación)
                val driver = PilotoDTO(
                    id = "1",
                    name = "Carlos Sainz",
                    team = EquipoDTO(
                        id = "2",
                        name = "Ferrari",
                        drivers = emptyList(),
                        championships = 16,
                        wins = 250,
                        podiums = 800,
                        imgId = R.drawable.ferrari
                    ),
                    wins = 18,
                    podiums = 90,
                    poles = 6,
                    imgId = R.drawable.sainz
                )

                pagePilotos(
                    driver = driver
                    // repository se inyecta por defecto (PilotosRepositoryMemory)
                )
            }
        }
    }
}


// Tema mínimo para Material3
@Composable
fun AppF1ThemeMinimal(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography(),
        content = content
    )
}

/**
 * MainMenu mostrando solo Carreras y Equipos
 */
@Composable
fun MainMenuCarrerasEquipos(viewModel: MainListVM, modifier: Modifier = Modifier) {
    val listas by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Carreras F1",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        SliderCarreras(listas.races, viewModel)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Equipos F1",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        SliderEquipos(listas.teams, viewModel)
        Text(
            text = "Pilotos F1",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        SliderPiltos(listas.drivers, viewModel)
    }
}

/**
 * Slider horizontal mostrando solo carreras
 */
@Composable
fun SliderCarreras(cardsInfo: List<CardSliderDetails>, viewModel: MainListVM) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardsInfo) { card ->
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .clickable { viewModel.onCardClicked(ListType.RACES) }
                    .padding(4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = card.imgId),
                        contentDescription = card.imgDesc,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = card.title,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

/**
 * Slider horizontal mostrando solo equipos
 */
@Composable
fun SliderEquipos(cardsInfo: List<CardSliderDetails>, viewModel: MainListVM) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardsInfo) { card ->
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .clickable { viewModel.onCardClicked(ListType.TEAM) }
                    .padding(4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = card.imgId),
                        contentDescription = card.imgDesc,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = card.title,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SliderPiltos(cardsInfo: List<CardSliderDetails>, viewModel: MainListVM) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardsInfo) { card ->
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .clickable { viewModel.onCardClicked(ListType.DRIVERS) }
                    .padding(4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = card.imgId),
                        contentDescription = card.imgDesc,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = card.title,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

