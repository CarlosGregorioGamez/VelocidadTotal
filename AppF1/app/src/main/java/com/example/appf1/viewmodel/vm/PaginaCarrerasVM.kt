package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.network.NetworkModule
import com.example.appf1.repository.CarreraRepository
import com.example.appf1.repository.CarrerasRepositoryMemory
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaCarrerasUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaginaCarrerasVM(
    private val repo: CarreraRepository = CarrerasRepositoryMemory(NetworkModule.appF1Service)
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<PaginaCarrerasUIState>>(emptyList())

    val uiState: StateFlow<List<PaginaCarrerasUIState>> = _uiState

    private val _selectedRace = MutableStateFlow<CarreraDTO?>(null)
    val selectedRace: StateFlow<CarreraDTO?> = _selectedRace

    init {
        viewModelScope.launch {
            cargarCarreras()
        }
    }

    suspend fun cargarCarreras() {
        _uiState.value = repo.getAllCarreras().map { carrera ->
            PaginaCarrerasUIState(
                id = carrera.id,
                name = carrera.name,
                editions = carrera.editions,
                country = carrera.country,
                winner = carrera.winner,
                podium = carrera.podium,
                length = carrera.length,
                imgId = carrera.imgId
            )
        }
    }


    fun loadCarrera(id: String) {
        _selectedRace.value = MainListRepositoryMemory.carrerasBase[id]
    }

    suspend fun getCarreraById(id: String): CarreraDTO? {
        return repo.getCarreraById(id)
    }

    fun getWinnerCarrera(carrera: CarreraDTO): String {
        return repo.getWinnerCarrera(carrera)
    }

    fun getPodiumCarrera(carrera: CarreraDTO): List<String> {
        return repo.getPodiumCarrera(carrera)
    }

}