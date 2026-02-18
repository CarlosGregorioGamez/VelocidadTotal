package com.example.appf1.remote.api

import com.example.appf1.remote.dto.PilotoRetroDTO
import retrofit2.Response
import retrofit2.http.GET


interface PilotosapiService {
    @GET("json/pilotos")
    suspend fun getPilotos(): Response<List<PilotoRetroDTO>>

}

