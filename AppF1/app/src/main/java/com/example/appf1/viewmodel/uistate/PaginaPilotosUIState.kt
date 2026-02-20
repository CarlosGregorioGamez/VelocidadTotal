package com.example.appf1.viewmodel.uistate

data class PaginaPilotosUIState(val id: String, val name: String, val team: String, val wins: List<String> = emptyList(), val podiums: List<String> = emptyList(), val poles: Int = 0, val imgId: Int)
