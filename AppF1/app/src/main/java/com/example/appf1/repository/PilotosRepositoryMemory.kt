package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.MainListRepositoryMemory.Companion.equiposBase

class PilotosRepositoryMemory : PilotosRepository {

    private val mainRepo = MainListRepositoryMemory()
    private val pilotosBase = mainRepo.pilotosBase

    override fun getAllPilotos(): List<PilotoDTO> {
        return pilotosBase.values.toList()
    }

    override fun getPilotoById(id: String): PilotoDTO? {
        return pilotosBase[id]
    }


    override fun getCarrerasByPilot(pilotId: String): List<CarreraDTO> {
        val piloto = pilotosBase[pilotId] ?: return emptyList()

        val carrerasIds = (piloto.wins + piloto.podiums).distinct()

        return carrerasIds.mapNotNull { MainListRepositoryMemory.carrerasBase[it] }
    }
}
