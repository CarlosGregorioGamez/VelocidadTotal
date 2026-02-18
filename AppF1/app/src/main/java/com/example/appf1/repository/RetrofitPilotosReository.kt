package com.example.appf1.repository

import android.content.Context
import com.example.appf1.R
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class RetrofitPilotosRepository(
    private val context: Context
) : PilotosRepository {

    private val apiPilotos = RetrofitClient.pilotosApiService
    private var cachePilotos: List<PilotoDTO> = emptyList()

    override fun getAllPilotos(
        onError: (Throwable) -> Unit,
        onSuccess: (List<PilotoDTO>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiPilotos.getPilotos()

                if (response.isSuccessful) {
                    val body = response.body() ?: emptyList()

                    val pilotos = body.map { dto ->

                        val imageResId =
                            resolveDrawableResource(dto.imgId)
                                ?: R.drawable.ic_launcher_background

                        val equipoId = resolveEquipoId(dto.team)

                        PilotoDTO(
                            id = dto.id,
                            name = dto.name,
                            team = equipoId,
                            wins = dto.wins,
                            podiums = dto.podiums,
                            poles = 0,
                            imgId = imageResId
                        )
                    }
                    cachePilotos = pilotos
                    onSuccess(pilotos)


                } else {
                    onError(Exception("HTTP ${response.code()}"))
                }

            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    private fun resolveEquipoId(teamName: String): String {
        return MainListRepositoryMemory.equiposBase.values
            .firstOrNull { it.name.equals(teamName, true) }
            ?.id ?: "E00"
    }

    //Parchea Drawables.xml para que se pueda usar el nombre del piloto en el JSON.
    private fun resolveDrawableResource(value: String): Int? {
        val clean = value.removePrefix("R.drawable.")
        val resId = context.resources.getIdentifier(
            clean,
            "drawable",
            context.packageName
        )
        return if (resId != 0) resId else null
    }

    override fun getPilotoById(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): PilotoDTO? {
        if (cachePilotos.isEmpty()) {
            getAllPilotos(
                onError = onError,
                onSuccess = { }
            )
            return null
        }

        val piloto = cachePilotos.find { it.id == id }

        return if (piloto != null) {
            onSuccess()
            piloto
        } else {
            onError(Exception("Pilot not found"))
            null
        }
    }



    override fun getCarrerasByPilot(
        pilotId: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): List<CarreraDTO> {
        onSuccess()
        return emptyList()
    }

}
