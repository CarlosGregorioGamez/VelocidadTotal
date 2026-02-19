package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.CarreraRepository
import com.example.appf1.repository.CarrerasRepositoryMemory
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaCarrerasUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaCarrerasVM(private val repo: CarreraRepository = CarrerasRepositoryMemory()
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<PaginaCarrerasUIState>>(emptyList())
    val uiState: StateFlow<List<PaginaCarrerasUIState>> = _uiState

    private val _selectedRace = MutableStateFlow<CarreraDTO?>(null)
    val selectedRace: StateFlow<CarreraDTO?> = _selectedRace

    fun loadCarrera(id: String) {
        repo.getAllCarreras(
            onError = { _selectedRace.value = null },
            onSuccess = { carreras ->
                val carrera = carreras.find { it.id == id }
                _selectedRace.value = carrera
            }
        )
    }

}