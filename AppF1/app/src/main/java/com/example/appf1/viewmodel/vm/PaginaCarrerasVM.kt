package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.CarreraRepository
import com.example.appf1.repository.CarrerasRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaCarrerasUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaCarrerasVM(private val repo: CarreraRepository = CarrerasRepositoryMemory()
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<PaginaCarrerasUIState>>(emptyList())

    val uiState: StateFlow<List<PaginaCarrerasUIState>> = _uiState.asStateFlow()

    init {
        cargarCarreras()
    }

    fun cargarCarreras() {
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

    fun getCarreraById(id: String): CarreraDTO? {
        return repo.getCarreraById(id)
    }

    fun getWinnerCarrera(carrera: CarreraDTO): String {
        return repo.getWinnerCarrera(carrera)
    }

    fun getPodiumCarrera(carrera: CarreraDTO): List<String> {
        return repo.getPodiumCarrera(carrera)
    }

}