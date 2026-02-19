package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.EquipoRepository
import com.example.appf1.repository.EquipoRepositoryMemory
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaEquiposUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaEquiposVM(
    private val repo: EquipoRepository = EquipoRepositoryMemory()
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<PaginaEquiposUIState>>(emptyList())

    val uiState: StateFlow<List<PaginaEquiposUIState>> = _uiState.asStateFlow()

    private val _selectedTeam = MutableStateFlow<EquipoDTO?>(null)
    val selectedTeam: StateFlow<EquipoDTO?> = _selectedTeam

    fun loadEquipos(id: String) {
        repo.getAllEquipos(
            onError = { _selectedTeam.value = null },
            onSuccess = { equipos ->
                val equipo = equipos.find { it.id == id }
                _selectedTeam.value = equipo
            }
        )
    }

    fun getPilotosByTeam(id: String): List<PilotoDTO> {
        val equipo = _selectedTeam.value ?: return emptyList()

        return equipo.drivers.mapNotNull { pilotoId ->
            MainListRepositoryMemory.pilotosBase[pilotoId]
        }
    }
}