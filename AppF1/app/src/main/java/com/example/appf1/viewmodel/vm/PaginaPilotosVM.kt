import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.MainListRepositoryMemory
import com.example.appf1.repository.PilotosRepository
import com.example.appf1.repository.PilotosRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPilotosVM(
    private val repository: PilotosRepository = PilotosRepositoryMemory()
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<PaginaPilotosUIState>>(emptyList())
    val uiState: StateFlow<List<PaginaPilotosUIState>> = _uiState.asStateFlow()
    private val _selectedPilot = MutableStateFlow<PilotoDTO?>(null)
    val selectedPilot: StateFlow<PilotoDTO?> = _selectedPilot

    fun loadPilot(id: String) {
        repository.getAllPilotos(
            onError = { _selectedPilot.value = null },
            onSuccess = { pilotos ->
                val piloto = pilotos.find { it.id == id }
                _selectedPilot.value = piloto
            }
        )
    }

    fun getCarrerasByPilot(pilotId: String): List<CarreraDTO> {

        val piloto = _selectedPilot.value ?: return emptyList()

        val carrerasIds = piloto.wins + piloto.podiums

        return carrerasIds.mapNotNull { id ->
            MainListRepositoryMemory.carrerasBase[id]
        }
    }

}


