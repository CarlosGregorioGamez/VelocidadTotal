package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.repository.PilotoRepostoryMemory
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow

class PerfilVM : ViewModel() {
    private val _uiState = MutableStateFlow<List<PaginaPilotosUIState>>(emptyList())
    private val _repo = PilotoRepostoryMemory()
}