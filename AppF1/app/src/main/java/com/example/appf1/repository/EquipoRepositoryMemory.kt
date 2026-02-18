package com.example.appf1.repository

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

class EquipoRepositoryMemory : EquipoRepository {

    override fun getAllEquipos(): List<EquipoDTO> =
        MainListRepositoryMemory.equiposBase.values.toList()

    override fun getEquipoById(id: String): EquipoDTO? =
        MainListRepositoryMemory.equiposBase[id]

    override fun getPilotosByTeam(id: String): List<PilotoDTO> {
        val equipo = MainListRepositoryMemory.equiposBase[id] ?: return emptyList()

        return equipo.drivers.mapNotNull { pilotoId ->
            MainListRepositoryMemory.pilotosBase[pilotoId]
        }
    }

}

