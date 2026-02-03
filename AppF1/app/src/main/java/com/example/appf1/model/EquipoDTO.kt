package com.example.appf1.model

import com.example.appf1.model.PilotoDTO

class EquipoDTO(val id: String, val name: String, val drivers: List<PilotoDTO>, val championships: Int, val wins: Int, val podiums: Int)