package com.example.appf1.data.model

data class PilotoDTO(val id: String, val name: String, val team: EquipoDTO, val wins: Int = 0, val podiums: Int = 0, val poles: Int = 0, val imgId: Int)
