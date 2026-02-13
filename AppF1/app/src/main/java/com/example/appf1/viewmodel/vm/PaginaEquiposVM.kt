package com.example.appf1.viewmodel.vm

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.EquipoRepository
import com.example.appf1.repository.EquipoRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaEquiposUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaEquiposVM(
    private val repo: EquipoRepository = EquipoRepositoryMemory()
) {

    private val _uiState = MutableStateFlow<List<PaginaEquiposUIState>>(emptyList())

    val uiState: StateFlow<List<PaginaEquiposUIState>> = _uiState.asStateFlow()

    private val _selectedTeam = MutableStateFlow<EquipoDTO?>(null)
    val selectedTeam: StateFlow<EquipoDTO?> = _selectedTeam

    init {
        cargarEquipos()
    }

    fun cargarEquipos() {
        _uiState.value = repo.getAllEquipos().map { equipo ->
            PaginaEquiposUIState(
                id = equipo.id,
                name = equipo.name,
                drivers = equipo.drivers,
                championships = equipo.championships,
                wins = equipo.wins,
                podiums = equipo.podiums,
                imgId = equipo.imgId
            )
        }
    }

    fun loadEquipos(id: String) {
        _selectedTeam.value = repo.getEquipoById(id)
    }

    fun getEquipoById(id: String): EquipoDTO?{
        return repo.getEquipoById(id)
    }

    fun getPilotosByTeam(id: String): List<PilotoDTO>{
        return  repo.getPilotosByTeam(id)
    }

}