package com.example.appf1.repository

import android.content.Context
import com.example.appf1.R
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitCarrerasRepository(private val context: Context) : CarreraRepository {

    private val apiCarreras = RetrofitClient.carrerasApiService
    private var cacheCarreras: List<CarreraDTO> = emptyList()

    override fun getAllCarreras(
        onError: (Throwable) -> Unit,
        onSuccess: (List<CarreraDTO>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiCarreras.getCarreras()

                if (response.isSuccessful) {
                    val body = response.body() ?: emptyList()

                    val carreras = body.map { dto ->
                        val imageResId =
                            resolveDrawableResource(dto.imgId)
                                ?: R.drawable.ic_launcher_background

                        CarreraDTO(
                            id = dto.id,
                            name = dto.name,
                            editions = dto.editions,
                            country = dto.country,
                            winner = dto.winner,
                            podium = dto.podium,
                            length = dto.length,
                            imgId = imageResId
                        )
                    }

                    cacheCarreras = carreras
                    onSuccess(carreras)

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

    override fun getCarreraById(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): CarreraDTO? {

        if (cacheCarreras.isEmpty()) {
            onError(Exception("Cache empty"))
            return null
        }

        val carrera = cacheCarreras.find { it.id == id }

        return if (carrera != null) {
            onSuccess()
            carrera
        } else {
            onError(Exception("Carrera not found"))
            null
        }
    }

    override fun getWinnerCarrera(
        carrera: CarreraDTO,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): String {
        onSuccess()
        return carrera.winner
    }

    override fun getPodiumCarrera(
        carrera: CarreraDTO,
        onError: (Throwable) -> Unit,
        onSuccess: () -> Unit
    ): List<String> {
        onSuccess()
        return carrera.podium
    }
}
