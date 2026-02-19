package com.example.appf1.remote.dto

import com.google.gson.annotations.SerializedName

data class UsuarioRetroDTO (
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("passwd") val passwd: String,
)