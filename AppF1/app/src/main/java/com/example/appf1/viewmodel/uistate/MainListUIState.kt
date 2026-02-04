package com.example.appf1.viewmodel.uistate

import com.example.appf1.components.CardSliderDetails
import com.example.appf1.viewmodel.vm.ListType


data class MainListUIState(
    val races: List<CardSliderDetails>,
    val drivers: List<CardSliderDetails>,
    val teams: List<CardSliderDetails>,
    val selectedListType: ListType = ListType.Races
)