package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

class CarrerasRepositoryMemory: CarreraRepository {

    private val carrerasUi = MainListRepositoryMemory.carreras

    override fun getAllCarreras(): List<CarreraDTO> {
        return carrerasUi.map { card ->
            CarreraDTO(
                id = card.id,
                name = card.title,
                imgId = card.imgId
            )
        }
    }

    override fun getCarreraById(id: String): CarreraDTO? {
        return getAllCarreras().find { it.id == id }
    }

    override fun getWinnerCarrera(carrera: CarreraDTO): String {
        return carrera.winner
    }

    override fun getPodiumCarrera(carrera: CarreraDTO): List<String> {
        return carrera.podium
    }


}