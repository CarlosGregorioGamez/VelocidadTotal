package com.example.appf1.data.model

data class CarreraDTO (val id: String,
                       val name: String,
                       val editions: Int,
                       val country: String,
                       val winner: String,
                       val podium: List<String>,
                       val length: Double,
                       val imgId: Int
)