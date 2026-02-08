package com.example.appf1.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.viewmodel.vm.MainListVM
import com.example.appf1.components.SliderComponent
import com.example.appf1.components.TitleComponent
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
    modifier: Modifier = Modifier,
    viewModel: MainListVM = viewModel()
) {
    val listas by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    )
    {
        Column(
            modifier = Modifier
                .height(height = 500.dp)
                .width(width = 275.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleComponent(titlePage)
            LazyColumn {
                item {
                    SliderComponent(cardsInfo = listas.races, onCardClick = {
                        viewModel.onCardClicked(ListType.RACES)
                    }
                    )
                    SliderComponent(cardsInfo = listas.drivers, onCardClick = {
                        viewModel.onCardClicked(ListType.DRIVERS)
                    }
                    )
                    SliderComponent(cardsInfo = listas.teams, onCardClick = {
                        viewModel.onCardClicked(ListType.TEAM)
                    }
                    )
                }
            }
        }
    }
}


