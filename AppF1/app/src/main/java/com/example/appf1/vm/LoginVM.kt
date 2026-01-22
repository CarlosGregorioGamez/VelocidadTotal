package com.example.appf1.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.components.Login
import com.example.appf1.repository.UserRepostoryMemory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginVM : ViewModel() {

    private val _uiState = MutableStateFlow(Login())
    private val _userRepo = UserRepostoryMemory()

    val uiState: StateFlow<Login> = _uiState.asStateFlow()

    fun onEmailChange(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.update { it.copy(contrasenha = newPassword) }
    }
}