import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.PilotosRepository
import com.example.appf1.repository.PilotosRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PaginaPilotosVM(
    private val repository: PilotosRepository = PilotosRepositoryMemory()
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<PaginaPilotosUIState>>(emptyList())
    val uiState: StateFlow<List<PaginaPilotosUIState>> = _uiState
    private val _selectedPilot = MutableStateFlow<PilotoDTO?>(null)
    val selectedPilot: StateFlow<PilotoDTO?> = _selectedPilot
    private var pilotosCargados = false


    init {
        cargarPilotos()
    }

    private fun cargarPilotos() {
        repository.getAllPilotos(
            onError = { e ->
                _uiState.value = emptyList()
            },
            onSuccess = { pilotos ->
                _uiState.value = pilotos.map { piloto ->
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
        )
    }

    fun loadPilot(id: String) {

        if (!pilotosCargados) {
            repository.getAllPilotos(
                onError = { _selectedPilot.value = null },
                onSuccess = {
                    pilotosCargados = true
                    loadPilot(id) // volver a intentar
                }
            )
            return
        }

        repository.getPilotoById(
            id = id,
            onError = { _selectedPilot.value = null },
            onSuccess = {}
        )?.let {
            _selectedPilot.value = it
        }
    }






    fun getCarrerasByPilot(pilotId: String): List<CarreraDTO> {
        return repository.getCarrerasByPilot(
            pilotId = pilotId,
            onError = {},
            onSuccess = {}
        )
    }
}

