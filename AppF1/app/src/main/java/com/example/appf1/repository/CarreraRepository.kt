package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

interface CarreraRepository {

    suspend fun getAllCarreras(): List<CarreraDTO>

    suspend fun getCarreraById(id: String): CarreraDTO?

    fun getWinnerCarrera(carrera: CarreraDTO): String

    fun getPodiumCarrera(carrera: CarreraDTO): List<String>
}