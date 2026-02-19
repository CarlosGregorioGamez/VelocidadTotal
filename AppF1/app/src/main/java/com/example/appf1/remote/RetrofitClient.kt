package com.example.appf1.remote

import com.example.appf1.remote.api.CarrerasApiService
import com.example.appf1.remote.api.EquiposApiService
import com.example.appf1.remote.api.PilotosapiService
import com.example.appf1.remote.api.UsuariosApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:5131"

    private val okHttpClient: OkHttpClient by lazy(LazyThreadSafetyMode.NONE) {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit: Retrofit by lazy(LazyThreadSafetyMode.NONE) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val pilotosApiService: PilotosapiService by lazy(LazyThreadSafetyMode.NONE) {
        retrofit.create(PilotosapiService::class.java)
    }
    val carrerasApiService: CarrerasApiService by lazy(LazyThreadSafetyMode.NONE) {
        retrofit.create(CarrerasApiService::class.java)
    }
    val equiposApiService: EquiposApiService by lazy (LazyThreadSafetyMode.NONE) {
        retrofit.create(EquiposApiService::class.java)
    }

    val usuariosApiService: UsuariosApiService by lazy (LazyThreadSafetyMode.NONE) {
        retrofit.create(UsuariosApiService::class.java)
    }
}