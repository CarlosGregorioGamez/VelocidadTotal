package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

class CarrerasRepositoryMemory: CarreraRepository {

    private val carrerasUi = MainListRepositoryMemory.carreras

    override fun getAllCarreras(): List<CarreraDTO> {
        return carrerasUi.map { card ->
            CarreraDTO(
                id = card.id,
                name = card.title,
                editions = card.editions,
                country = card.country,
                winner = card.winner,
                podium = card.podium,
                length = card.length,
                imgId = card.imgId
            )
        }
        return emptyList()
    }

    override fun getCarreraById(id: String): CarreraDTO? {
        return getAllCarreras().find { it.id == id }
    }

    override fun getWinnerCarrera(piloto: PilotoDTO) {
        TODO("Not yet implemented")
    }

    override fun getPodiumCarrera(podio: List<PilotoDTO>) {
        TODO("Not yet implemented")
    }
}