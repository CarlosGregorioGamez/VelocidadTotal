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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.VM.MainListVM
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.appf1.components.TitleComponent

/**
 * Página que muestra un listado de tarjetas con información, en una lazycolumn para poder scrollear libremente
 *
 * @param titlePage
 * @param viewModel
 */
@Composable
fun MainMenu(titlePage: String = "", viewModel: MainListVM = viewModel()) {

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
                item{
                    SliderComponent(cardsInfo = listas.races)
                    SliderComponent(cardsInfo = listas.drivers)
                    SliderComponent(cardsInfo = listas.teams)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainMenuPreview() {
    MainMenu("Menú principal")
}