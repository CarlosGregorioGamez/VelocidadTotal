package com.example.appf1.repository

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

class EquipoRepositoryMemory: EquipoRepository {
    override fun getAllEquipos(): List<EquipoDTO> {
        TODO("Not yet implemented")
    }

    override fun getEquipoById(id: String): EquipoDTO? {
        TODO("Not yet implemented")
    }

    override fun getPilotosByTeam(id: String): List<PilotoDTO> {
        TODO("Not yet implemented")
    }
}