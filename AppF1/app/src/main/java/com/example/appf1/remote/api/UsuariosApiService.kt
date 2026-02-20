package com.example.appf1.remote.api

import com.example.appf1.remote.dto.PilotoRetroDTO
import com.example.appf1.remote.dto.UsuarioRetroDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuariosApiService {
    @GET("json/user")
    suspend fun getAllUsers(): Response<List<UsuarioRetroDTO>>

    @POST("json/user/{id}")
    suspend fun updateUser(
        @Path("id") id: String,
        @Body user: UsuarioRetroDTO
    ): Response<UsuarioRetroDTO>
}