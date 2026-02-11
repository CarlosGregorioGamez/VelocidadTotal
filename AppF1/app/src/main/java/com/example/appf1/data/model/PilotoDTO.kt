package com.example.appf1.data.model


data class PilotoDTO(val id: String,
                     val name: String,
                     val team: EquipoDTO,
                     val wins: List<String> = emptyList(),
                     val podiums: List<String> = emptyList(),
                     val poles: Int = 0,
                     val imgId: Int,
                     val carreras: List<CarreraDTO> = emptyList()
)
