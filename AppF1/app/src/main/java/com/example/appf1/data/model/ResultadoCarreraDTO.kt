package com.example.appf1.data.model

data class ResultadoCarreraDTO(
    val idCarrera: String,
    val idWinner: String,
    val idPodium: List<String>
)