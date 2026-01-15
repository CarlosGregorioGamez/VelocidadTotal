package com.example.appf1.VM

import androidx.lifecycle.ViewModel
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.repository.MainListRepositoryMemory
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.appf1.repository.UserRepostoryMemory
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainListVM: ViewModel() {

    private val _mainListRepo = MainListRepositoryMemory()
    private val _uiState = MutableStateFlow(MainList(
        races = _mainListRepo.getRaces(),
        drivers = TODO(),
        teams = TODO()
    ))


    val uiState: StateFlow<MainList> = _uiState.asStateFlow()

    
}

data class MainList(val races: List<CardSliderDetails>, val drivers: List<CardSliderDetails>, val teams: List<CardSliderDetails>)