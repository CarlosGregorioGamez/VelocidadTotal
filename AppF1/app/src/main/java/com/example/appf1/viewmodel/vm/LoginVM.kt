package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
                android.util.Log.e("LOGIN", "Login fallido: ${throwable.message}")
            },
            onSuccess = { user ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = null
                    )
                }
                android.util.Log.i("LOGIN", "Login correcto: ${user.email}")
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

class LoginVMFactory(
    private val repository: UserRepostoryMemory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}