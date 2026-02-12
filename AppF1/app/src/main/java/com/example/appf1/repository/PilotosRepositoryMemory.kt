package com.example.appf1.repository

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.MainListRepositoryMemory.Companion.equiposBase

class PilotosRepositoryMemory : PilotosRepository {

    private val pilotosUi = MainListRepositoryMemory.pilotos

    override fun getAllPilotos(): List<PilotoDTO> {
        return pilotosUi.map { card ->
            PilotoDTO(
                id = card.id,
                name = card.title,
                team = equipoPorPiloto(card.id).name,
                imgId = card.imgId
            )
        }
    }

    override fun getPilotoById(id: String): PilotoDTO? {
        return getAllPilotos().find { it.id == id }
    }

    private fun equipoPorPiloto(pilotoId: String): EquipoDTO {
        return when (pilotoId) {
            "P01", "P14" -> equiposBase.getValue("E11")
            "P04", "P18", "P22" -> equiposBase.getValue("E05")
            "P07", "P06" -> equiposBase.getValue("E02")
            "P09", "P17", "P13" -> equiposBase.getValue("E08")
            "P11", "P16" -> equiposBase.getValue("E07")
            "P12", "P05", "P20" -> equiposBase.getValue("E10")
            "P19", "P21" -> equiposBase.getValue("E01")
            else -> equiposBase.getValue("E03")
        }
    }
}
