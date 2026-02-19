package com.example.appf1.remote.api

import com.example.appf1.remote.dto.PilotoRetroDTO
import com.example.appf1.remote.dto.UsuarioRetroDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsuariosApiService {
    @GET("json/user/{id}")
    suspend fun getUser(@Path("id")id: String): Response<UsuarioRetroDTO>
}