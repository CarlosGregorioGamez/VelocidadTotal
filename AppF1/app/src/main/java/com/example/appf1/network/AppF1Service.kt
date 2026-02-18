package com.example.appf1.network

import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.UserDTO
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AppF1Service{

    @POST("appF1/login")
    suspend fun login(
        @Body loginRequest: LoginDTO
    ): Response<LoginResponseDTO>

@GET("piloto/{id}")
suspend fun getPiloto(@Path("id") id: String): Response<PilotoResponse>

@GET("piloto")
suspend fun getPilotoList(@Query("limit") limit: Int = 50, @Query("offset") offset: Int = 0): Response<PokemonListResponse>
}

data class PilotoResponse(
    val id: String,
    val name: String,
    @SerializedName("sprites") val sprites: Sprites,
    val team: EquipoDTO,
    @SerializedName("victorias") val wins: List<StatEntry> = emptyList(),
    @SerializedName("podios") val podios: List<MoveEntry> = emptyList()
)

data class LoginDTO(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)


class MovesEntry {
    @SerializedName("name") val name: String = ""
}

class StatEntry(
    @SerializedName("base_stat") val baseStat: Int,
    val stat: StatRef
)

class StatRef(
    val name: String,
    val url: String
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String?
)

data class LoginResponseDTO(
    val user: UserDTO
)

data class PokemonListResponse(
    val results: List<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val url: String
)

data class TypeEntry(
    val slot: Int,
    val type: TypeRef
)

data class TypeRef(
    val name: String,
    val url: String
)

data class MoveEntry(
    val move: MoveRef
)

data class MoveRef(
    val name: String,
    val url: String
)