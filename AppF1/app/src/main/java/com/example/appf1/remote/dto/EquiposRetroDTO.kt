package com.example.appf1.remote.dto

import com.google.gson.annotations.SerializedName

data class EquiposRetroDTO(
    @SerializedName("id")val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("drivers")val drivers: List<String> = emptyList(),
    @SerializedName("championships")val championships: Int = 0,
    @SerializedName("wins")val wins: Int = 0,
    @SerializedName("podiums")val podiums: Int = 0,
    @SerializedName("image")val imgId: String
)
