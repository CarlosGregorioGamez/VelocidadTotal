package com.example.appf1.model

data class PilotoDTO(val id: String, val name: String, val team: String, val wins: Int = 0, val podiums: Int = 0, val poles: Int = 0)
