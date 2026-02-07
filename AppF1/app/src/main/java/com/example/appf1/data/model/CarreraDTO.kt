package com.example.appf1.data.model

data class CarreraDTO (val id: String, val name: String, val editions: Int, val country: String, val winner: PilotoDTO, val podium: List<PilotoDTO>, val length: Double, val imgId: Int)