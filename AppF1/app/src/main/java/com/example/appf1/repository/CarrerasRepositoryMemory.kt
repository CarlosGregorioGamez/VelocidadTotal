package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
class CarrerasRepositoryMemory : CarreraRepository {

    private val carrerasBase = MainListRepositoryMemory.carrerasBase

    override fun getAllCarreras(
        onError: (Throwable) -> Unit,
        onSuccess: (List<CarreraDTO>) -> Unit
    ) {
        try {
            onSuccess(carrerasBase.values.toList())
        } catch (e: Exception) {
            onError(e)
        }
    }

    override fun getCarreraById(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): CarreraDTO? {
        return try {
            val carrera = carrerasBase[id]
            onSuccess()
            carrera
        } catch (e: Exception) {
            onError(e)
            null
        }
    }

    override fun getWinnerCarrera(
        carrera: CarreraDTO,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): String {
        return try {
            onSuccess()
            carrera.winner
        } catch (e: Exception) {
            onError(e)
            ""
        }
    }

    override fun getPodiumCarrera(
        carrera: CarreraDTO,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): List<String> {
        return try {
            onSuccess()
            carrera.podium
        } catch (e: Exception) {
            onError(e)
            emptyList()
        }
    }
}
