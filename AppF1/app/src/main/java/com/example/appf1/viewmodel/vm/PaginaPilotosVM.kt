import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
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

    init {
        cargarPilotos()
    }

    private fun cargarPilotos() {
        _uiState.value = repository.getAllPilotos().map { piloto ->
            PaginaPilotosUIState(
                id = piloto.id,
                name = piloto.name,
                team = piloto.team,
                wins = piloto.wins,
                podiums = piloto.podiums,
                poles = piloto.poles
            )
        }
    }

    fun loadPilot(id: String) {
        _selectedPilot.value = repository.getPilotoById(id)
    }

    fun getPilotoById(id: String): PilotoDTO? {
        return repository.getPilotoById(id)
    }

    fun getCarrerasByPilot(pilotId: String): List<CarreraDTO> {
        return repository.getCarrerasByPilot(pilotId)
    }


    class PaginaPilotosVMFactory(
        private val repository: PilotosRepository = PilotosRepositoryMemory()
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PaginaPilotosVM::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PaginaPilotosVM(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

