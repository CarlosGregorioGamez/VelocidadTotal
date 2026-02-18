package com.example.appf1.remote.api


import com.example.appf1.remote.dto.CarreraRetroDTO
import retrofit2.Response
import retrofit2.http.GET

interface CarrerasApiService {
        @GET("json/carreras")
        suspend fun getCarreras(): Response<List<CarreraRetroDTO>>
}