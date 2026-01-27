package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.repository.MainListRepositoryMemory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainListVM : ViewModel() {

    private val _mainListRepo = MainListRepositoryMemory()
    private val _uiState = MutableStateFlow(
        UIMainList(
            races = _mainListRepo.getRaces(),
            drivers = _mainListRepo.getPilots(),
            teams = _mainListRepo.getTeams()
        )
    )


    val uiState: StateFlow<UIMainList> = _uiState.asStateFlow()

    fun onCardClicked() {

    }

}

data class UIMainList(
    val races: List<CardSliderDetails>,
    val drivers: List<CardSliderDetails>,
    val teams: List<CardSliderDetails>
)