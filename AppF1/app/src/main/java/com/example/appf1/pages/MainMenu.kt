package com.example.appf1.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appf1.viewmodel.vm.MainListVM
import com.example.appf1.components.SliderComponent
import com.example.appf1.components.TitleComponent
import com.example.appf1.components.TopBarComponent
import com.example.appf1.viewmodel.vm.ListType

/**
 * Página que muestra un listado de tarjetas con información, en una lazycolumn para poder scrollear libremente
 *
 * @param titlePage
 * @param viewModel
 */
@Composable
fun MainMenu(
    titlePage: String = "",
    viewModel: MainListVM = viewModel(),
    navController: NavController
) {
    val listas by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopBarComponent(
                topBarTitle = titlePage,
                navIcon = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            )
        }
    )  { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .height(500.dp)
                    .width(275.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleComponent(titlePage)
                LazyColumn {
                    item {
                        TitleComponent("Carreras")
                        SliderComponent(cardsInfo = listas.races) {
                            viewModel.onCardClicked(ListType.RACES)
                        }
                        TitleComponent("Pilotos")
                        SliderComponent(cardsInfo = listas.drivers) {
                            viewModel.onCardClicked(ListType.DRIVERS)
                        }
                        TitleComponent("Equipos")
                        SliderComponent(cardsInfo = listas.teams) {
                            viewModel.onCardClicked(ListType.TEAM)
                        }
                    }
                }
            }
        }
    }
}



