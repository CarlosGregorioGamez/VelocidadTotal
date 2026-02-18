package com.example.appf1.repository

import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO

interface CarreraRepository {

    fun getAllCarreras(onError: (Throwable) -> Unit,
                       onSuccess: (List<CarreraDTO>) -> Unit)

    fun getCarreraById(id: String,onError: (Throwable) -> Unit,
                       onSuccess: () -> Unit): CarreraDTO?

    fun getWinnerCarrera(carrera: CarreraDTO,onError: (Throwable) -> Unit,
                         onSuccess: () -> Unit): String

    fun getPodiumCarrera(carrera: CarreraDTO,onError: (Throwable) -> Unit,
                         onSuccess: () -> Unit): List<String>
}