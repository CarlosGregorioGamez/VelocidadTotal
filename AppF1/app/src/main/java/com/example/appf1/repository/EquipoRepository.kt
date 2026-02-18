package com.example.appf1.repository

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

interface EquipoRepository {

    fun getAllEquipos(onError: (Throwable) -> Unit,
                      onSuccess: (List<EquipoDTO>) -> Unit)

    fun getEquipoById(id: String, onError: (Throwable) -> Unit,
                      onSuccess:()-> Unit): EquipoDTO?

    fun getPilotosByTeam(id: String,onError: (Throwable) -> Unit,
                         onSuccess:()-> Unit): List<PilotoDTO>

}