package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.repository.RetrofitLoginRepository
import com.example.appf1.viewmodel.uistate.LoginUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginVM (private val retrofitLoginRepository: RetrofitLoginRepository): ViewModel(){
    private val _uiState = MutableStateFlow(LoginUIState())

    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()

    fun login(onSuccess: () -> Unit) {
        val id = uiState.value.id
        val email = uiState.value.email
        val passwd = uiState.value.password

        _uiState.update { it.copy(isLoading = true, error = null) }

        retrofitLoginRepository.getUser(
            email = email,
            passwd = passwd,
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

    fun resetFields(){
        _uiState.update { it.copy( email = "", password = "", error = null, isLoading = false) }
    }

    fun onEmailChange(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }


}

class LoginVMFactory(
    private val repository: RetrofitLoginRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}