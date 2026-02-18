package com.example.appf1.repository

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

class EquipoRepositoryMemory : EquipoRepository {

    private val equiposBase = MainListRepositoryMemory.equiposBase

    override fun getAllEquipos(
        onError: (Throwable) -> Unit,
        onSuccess: (List<EquipoDTO>) -> Unit
    ) {
        try {
            onSuccess(equiposBase.values.toList())
        } catch (e: Exception) {
            onError(e)
        }
    }

    override fun getEquipoById(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): EquipoDTO? {

        val equipo = equiposBase[id]

        return if (equipo != null) {
            onSuccess()
            equipo
        } else {
            onError(Exception("Equipo not found"))
            null
        }
    }

    override fun getPilotosByTeam(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): List<PilotoDTO> {

        val equipo = equiposBase[id]
            ?: return emptyList()

        val pilotos = equipo.drivers.mapNotNull { pilotoId ->
            MainListRepositoryMemory.pilotosBase[pilotoId]
        }

        onSuccess()
        return pilotos
    }
}


