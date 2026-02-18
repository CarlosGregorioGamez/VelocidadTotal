package com.example.appf1.network

import com.example.appf1.data.model.UserDTO
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AppF1Service {

    @POST("appF1/login")
    suspend fun login(
        @Body loginRequest: LoginDTO
    ): Response<LoginResponseDTO>

    @GET("piloto/{id}")
    suspend fun getPiloto(@Path("id") id: String): Response<PilotoResponse>

    @GET("piloto")
    suspend fun getPilotoList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): Response<PilotoListResponse>


    @GET("carrera/{id}")
    suspend fun getCarrera(@Path("id") id: String): Response<CarreraResponse>

    @GET("carrera")
    suspend fun getCarreraList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): Response<CarreraListResponse>


    @GET("equipo/{id}")
    suspend fun getEquipo(@Path("id") id: String): Response<EquipoResponse>

    @GET("equipo")
    suspend fun getEquipoList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): Response<EquipoListResponse>


    data class PilotoResponse(
        val id: String,
        val name: String,
        val team: String,
        val wins: List<WinsEntry> = emptyList(),
        val podium: List<PodiumEntry> = emptyList(),
        val poles: Int = 0,
        val imgId: Int,
    )

    data class CarreraResponse(
        val id: String,
        val name: String,
        val editions: Int = 0,
        val country: String = "",
        val winner: String = "",
        val podium: List<String> = emptyList(),
        val length: Double = 0.0,
        val imgId: Int
    )

    data class EquipoResponse(
        val id: String,
        val name: String, val drivers: List<String> = emptyList(),
        val championships: Int = 0,
        val wins: Int = 0,
        val podiums: Int = 0,
        val imgId: Int
    )

    data class LoginDTO(
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
    )

    class WinsEntry(
         val wins: List<String>
    )

    class PodiumEntry {
        val podiums: List<String> = emptyList()
    }


    data class LoginResponseDTO(
        val user: UserDTO
    )

    data class PilotoListResponse(
        val results: List<PilotoListItem>
    )

    data class PilotoListItem(
        val name: String,
        val url: String
    )

    data class EquipoListResponse(
        val results: List<EquipoListItem>
    )

    data class EquipoListItem(
        val name: String,
        val url: String
    )


    data class CarreraListResponse(
        val results: List<CarreraListItem>
    )

    data class CarreraListItem(
        val name: String,
        val url: String
    )
}
