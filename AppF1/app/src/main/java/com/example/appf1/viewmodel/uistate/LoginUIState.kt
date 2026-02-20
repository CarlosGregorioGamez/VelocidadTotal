package com.example.appf1.viewmodel.uistate

data class LoginUIState(
    val id: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

