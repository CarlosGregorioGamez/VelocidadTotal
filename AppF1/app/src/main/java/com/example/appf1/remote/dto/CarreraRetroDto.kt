package com.example.appf1.remote.dto

import com.google.gson.annotations.SerializedName

data class CarreraRetroDto(
    @SerializedName("id") val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("editions")val editions: Int = 0,
    @SerializedName("country")val country: String = "",
    @SerializedName("winner")val winner: String = "",
    @SerializedName("podium")val podium: List<String> = emptyList(),
    @SerializedName("length")val length: Double = 0.0,
    @SerializedName("image")val imgId: String
)
