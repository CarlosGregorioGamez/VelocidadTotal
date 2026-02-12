package com.example.appf1.repository
import com.example.appf1.data.model.PilotoDTO

interface PilotosRepository {
    fun getAllPilotos(): List<PilotoDTO>
    fun getPilotoById(id: String): PilotoDTO?
}
