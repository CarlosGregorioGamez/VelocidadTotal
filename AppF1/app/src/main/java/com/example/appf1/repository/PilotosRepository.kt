package com.example.appf1.repository
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

interface PilotosRepository {
    fun getAllPilotos(onError: (Throwable) -> Unit,
                      onSuccess: (List<PilotoDTO>) -> Unit)
    fun getPilotoById(id: String, onError: (Throwable) -> Unit,
                      onSuccess: () -> Unit): PilotoDTO?
    fun getCarrerasByPilot(pilotId: String, onError: (Throwable) -> Unit,
                           onSuccess: () -> Unit): List<CarreraDTO>
}
