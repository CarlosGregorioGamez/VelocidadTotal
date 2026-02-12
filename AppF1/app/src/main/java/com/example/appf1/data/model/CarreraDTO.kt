package com.example.appf1.data.model

data class CarreraDTO(
    val id: String,
    val name: String,
    val editions: Int = 0,
    val country: String = "",
    val winner: String = "",
    val podium: List<String> = emptyList(),
    val length: Double = 0.0,
    val imgId: Int
)