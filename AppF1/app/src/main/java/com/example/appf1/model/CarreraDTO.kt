package com.example.appf1.model

import com.example.appf1.model.PilotoDTO

class CarreraDTO (val id: String, val name: String, val editions: Int, val country: String, val winner: PilotoDTO, val podium: List<PilotoDTO>, val lenght: Double)