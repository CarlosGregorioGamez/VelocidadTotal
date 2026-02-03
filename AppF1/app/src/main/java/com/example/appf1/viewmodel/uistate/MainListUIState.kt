package com.example.appf1.viewmodel.uistate

import com.example.appf1.components.CardSliderDetails

data class MainListUIState(
    val races: List<CardSliderDetails>,
    val drivers: List<CardSliderDetails>,
    val teams: List<CardSliderDetails>
)