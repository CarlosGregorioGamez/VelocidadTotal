package com.example.appf1.repository

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

interface EquipoRepository {

    fun getAllEquipos(): List<EquipoDTO>

    fun getEquipoById(id: String): EquipoDTO?

    fun getPilotosByTeam(id: String): List<PilotoDTO>

}