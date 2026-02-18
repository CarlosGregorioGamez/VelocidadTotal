package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.network.AppF1Service

class CarrerasRepositoryMemory(
    private val api: AppF1Service
): CarreraRepository {
    override suspend fun getAllCarreras(): List<CarreraDTO> {
        val response = api.getCarreraList()

        if (!response.isSuccessful) return emptyList()

        return response.body()?.results?.map { item ->
            CarreraDTO(
                id = idURL(item.url),
                name = item.name,
                imgId = 0 // luego se cambiaria esto
            )
        } ?: emptyList()
    }

    override suspend fun getCarreraById(id: String): CarreraDTO? {
        val response = api.getCarrera(id)

        if (!response.isSuccessful) return null

        val body = response.body() ?: return null

        return CarreraDTO(
            id = body.id,
            name = body.name,
            imgId = body.imgId,
            winner = body.winner,
            podium = body.podium
        )
    }

    override fun getWinnerCarrera(carrera: CarreraDTO): String {
        return carrera.winner
    }

    override fun getPodiumCarrera(carrera: CarreraDTO): List<String> {
        return carrera.podium
    }

    private fun idURL(url: String): String {
        return url.substringAfterLast("/").removeSuffix("/")
    }
}