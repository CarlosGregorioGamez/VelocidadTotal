package com.example.appf1.viewmodel.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.model.UserDTO
import com.example.appf1.repository.PilotoRepostoryMemory
import com.example.appf1.repository.UserRepostoryMemory
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PerfilVM(private val repository: UserRepostoryMemory) : ViewModel() {

        private val _uiState = MutableStateFlow<UserDTO?>(null)
        val uiState: StateFlow<UserDTO?> = _uiState.asStateFlow()

        init {
            loadDefaultUser()
        }

        private fun loadDefaultUser() {
            try {
                val defaultUser = UserRepostoryMemory.usuarios[0]
                _uiState.value = defaultUser
            } catch (e: Exception) {
                Log.e("PerfilVM", "No hay usuario disponible: ${e.message}")
            }
        }
    }


class PerfilVMFactory(
    private val repository: UserRepostoryMemory
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PerfilVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PerfilVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
