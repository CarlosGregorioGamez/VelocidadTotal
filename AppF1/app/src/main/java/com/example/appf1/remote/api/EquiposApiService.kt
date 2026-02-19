package com.example.appf1.remote.api


import com.example.appf1.remote.dto.EquiposRetroDTO
import retrofit2.Response
import retrofit2.http.GET

interface EquiposApiService {
    @GET("json/equipos")
    suspend fun getEquipos(): Response<List<EquiposRetroDTO>>
}