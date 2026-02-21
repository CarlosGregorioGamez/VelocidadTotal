package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.data.model.SessionManager
import com.example.appf1.data.model.UserDTO
import com.example.appf1.repository.RetrofitLoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PerfilVM(private val repository: RetrofitLoginRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UserDTO?>(null)
    val uiState: StateFlow<UserDTO?> = _uiState.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        _uiState.value = SessionManager.currUser
    }

    fun loadUser(user: UserDTO) {
        _uiState.value = user
    }

    fun updateEmail(newEmail: String) {
        _uiState.value = _uiState.value?.copy(email = newEmail)
    }

    fun updatePassword(newPassword: String) {
        _uiState.value = _uiState.value?.copy(password = newPassword)
    }

    fun saveChanges(onSuccess: () -> Unit = {}) {
        val user = _uiState.value ?: return

        _error.value = null

        repository.updateUser(user,
            onSuccess = {
                SessionManager.currUser = user
            },
            onError = { throwable ->
                _error.value = throwable.message
            }
        )
    }
}


class PerfilVMFactory(
    private val repository: RetrofitLoginRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PerfilVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PerfilVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}