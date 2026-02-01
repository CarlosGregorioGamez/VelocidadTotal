package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.repository.UserRepostoryMemory
import com.example.appf1.viewmodel.uistate.LoginUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginVM (private val userRepostoryMemory: UserRepostoryMemory): ViewModel(){
    private val _uiState = MutableStateFlow(LoginUIState())

    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()

    fun login(onSuccess: () -> Unit) {
        val email = uiState.value.email
        val password = uiState.value.password

        _uiState.update { it.copy(isLoading = true, error = null) }

        userRepostoryMemory.login(
            email = email,
            password = password,
            onError = { throwable ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = throwable.message
                    )
                }
            },
            onSuccess = { user ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = null
                    )
                }
                onSuccess()
            }
        )
    }

    fun onEmailChange(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }
}