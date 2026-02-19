package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

class PilotosRepositoryMemory : PilotosRepository {

    private val pilotosBase = MainListRepositoryMemory.pilotosBase
    private val carrerasBase = MainListRepositoryMemory.carrerasBase

    override fun getAllPilotos(
        onError: (Throwable) -> Unit,
        onSuccess: (List<PilotoDTO>) -> Unit
    ) {
        try {
            onSuccess(pilotosBase.values.toList())
        } catch (e: Exception) {
            onError(e)
        }
    }

    override fun getPilotoById(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): PilotoDTO? {
        return try {
            val piloto = pilotosBase[id]
            onSuccess()
            piloto
        } catch (e: Exception) {
            onError(e)
            null
        }
    }

    override fun getCarrerasByPilot(
        pilotId: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): List<CarreraDTO> {
        return try {
            val carreras = carrerasBase.values.filter { carrera ->
                carrera.winner == pilotId ||
                        carrera.podium.contains(pilotId)
            }
            onSuccess()
            carreras
        } catch (e: Exception) {
            onError(e)
            emptyList()
        }
    }
}


