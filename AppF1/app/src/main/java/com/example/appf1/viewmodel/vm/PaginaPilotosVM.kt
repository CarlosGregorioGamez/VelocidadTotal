package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.repository.RetrofitPilotosRepository
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPilotosVM(
    private val repository: RetrofitPilotosRepository
) : ViewModel() {

    private val _selectedPilot = MutableStateFlow<PilotoDTO?>(null)
    val selectedPilot: StateFlow<PilotoDTO?> = _selectedPilot.asStateFlow()

    private val _top3Races = MutableStateFlow<List<CarreraDTO>>(emptyList())
    val top3Races: StateFlow<List<CarreraDTO>> = _top3Races.asStateFlow()

    fun loadPilot(id: String) {
        repository.getAllPilotos(
            onError = {
                _selectedPilot.value = null
                _top3Races.value = emptyList()
            },
            onSuccess = { pilotos ->
                val piloto = pilotos.find { it.id == id }
                _selectedPilot.value = piloto

                piloto?.let {
                    val carrerasIds = (it.wins + it.podiums).distinct()

                    val carreras = carrerasIds.mapNotNull { carreraId ->
                        MainListRepositoryMemory.carrerasBase[carreraId]
                    }

                    _top3Races.value = carreras
                } ?: run {
                    _top3Races.value = emptyList()
                }
            }
        )
    }
}