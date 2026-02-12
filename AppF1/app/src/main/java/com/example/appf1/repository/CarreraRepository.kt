package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

interface CarreraRepository {

    fun getAllCarreras(): List<CarreraDTO>

    fun getCarreraById(id: String): CarreraDTO?

    fun getWinnerCarrera(carrera: CarreraDTO): String

    fun getPodiumCarrera(carrera: CarreraDTO): List<String>
}