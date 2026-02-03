package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.repository.PilotoRepostoryMemory
import com.example.appf1.viewmodel.uistate.PaginaCarrerasUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaCarrerasVM : ViewModel() {
    private val _uiState = MutableStateFlow<List<PaginaCarrerasUIState>>(emptyList())
    private val _repo = PilotoRepostoryMemory()

    val uiState: StateFlow<List<PaginaCarrerasUIState>> = _uiState.asStateFlow()

    fun verCarrera(){

    }

}