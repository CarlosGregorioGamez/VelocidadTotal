package com.example.appf1.repository
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

interface PilotosRepository {
    fun getAllPilotos(): List<PilotoDTO>
    fun getPilotoById(id: String): PilotoDTO?
    fun getCarrerasByPilot(pilotId: String): List<CarreraDTO>
}
