package com.example.appf1.remote.dto

import com.google.gson.annotations.SerializedName

data class PilotoRetroDTO(
    @SerializedName("id") val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("team")val team: String,
    @SerializedName("wins")val wins: List<String> = emptyList(),
    @SerializedName("podiums")val podiums: List<String> = emptyList(),
    @SerializedName("image")val imgId: String
)
