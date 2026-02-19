package com.example.appf1.repository

import android.content.Context
import com.example.appf1.R
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.String

class RetrofitEquiposRepository(private val context: Context): EquipoRepository {
    private val apiequipos = RetrofitClient.equiposApiService
    private var cacheEquipos: List<EquipoDTO> = emptyList()
    override fun getAllEquipos(
        onError: (Throwable) -> Unit,
        onSuccess: (List<EquipoDTO>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiequipos.getEquipos()

                if (response.isSuccessful) {
                    val body = response.body() ?: emptyList()

                    val equipos = body.map { dto ->
                        val imageResId =
                            resolveDrawableResource(dto.imgId)
                                ?: R.drawable.ic_launcher_background

                        EquipoDTO(
                            id= dto.id,
                        name=dto.name,
                        drivers=dto.drivers,
                        championships=dto.championships,
                        wins=dto.wins,
                        podiums=dto.podiums,
                        imgId=imageResId
                        )
                    }

                    cacheEquipos = equipos
                    onSuccess(equipos)

                } else {
                    onError(Exception("HTTP ${response.code()}"))
                }

            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    private fun resolveDrawableResource(value: String): Int? {
        val clean = value.removePrefix("R.drawable.")
        val resId = context.resources.getIdentifier(
            clean,
            "drawable",
            context.packageName
        )
        return if (resId != 0) resId else null
    }

    override fun getEquipoById(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): EquipoDTO? {
        onSuccess()
        return cacheEquipos.find { it.id == id }
    }

    override fun getPilotosByTeam(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): List<PilotoDTO> {
        val equipo = cacheEquipos.find { it.id == id }
            ?: return emptyList()

        val pilotos = equipo.drivers.mapNotNull { pilotoId ->
            MainListRepositoryMemory.pilotosBase[pilotoId]
        }

        onSuccess()
        return pilotos
    }


}