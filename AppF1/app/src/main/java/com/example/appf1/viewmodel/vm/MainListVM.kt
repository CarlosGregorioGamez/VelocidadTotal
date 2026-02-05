package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.viewmodel.uistate.MainListUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainListVM : ViewModel() {

    private val _mainListRepo = MainListRepositoryMemory()
    private val _uiState = MutableStateFlow(
        MainListUIState(
            races = _mainListRepo.getRaces(),
            drivers = _mainListRepo.getPilots(),
            teams = _mainListRepo.getTeams()
        )
    )


    val uiState: StateFlow<MainListUIState> = _uiState.asStateFlow()

    fun onCardClicked(type: ListType) {
        _uiState.value = _uiState.value.copy(selectedListType = type)
    }

    fun getSelectedList(): List<CardSliderDetails> =
        when (_uiState.value.selectedListType) {
            ListType.RACES -> _mainListRepo.getRaces()
            ListType.DRIVERS -> _mainListRepo.getPilots()
            ListType.TEAM -> _mainListRepo.getTeams()
        }
}

