package com.example.appf1.viewmodel.uistate

class PaginaEquiposUIState(
    val id: String,
    val name: String,
    val drivers: List<String> = emptyList(),
    val championships: Int = 0,
    val wins: Int = 0,
    val podiums: Int = 0,
    val imgId: Int
)