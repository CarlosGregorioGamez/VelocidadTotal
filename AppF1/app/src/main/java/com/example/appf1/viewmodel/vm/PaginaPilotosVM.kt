import androidx.lifecycle.ViewModel
import com.example.appf1.data.model.PilotoDTO
import com.example.appf1.repository.PilotosRepository
import com.example.appf1.repository.PilotosRepositoryMemory
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PaginaPilotosVM(
    private val repository: PilotosRepository = PilotosRepositoryMemory()
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<List<PaginaPilotosUIState>>(emptyList())
    val uiState: StateFlow<List<PaginaPilotosUIState>> = _uiState

    init {
        cargarPilotos()
    }

    private fun cargarPilotos() {
        _uiState.value = repository.getAllPilotos().map { piloto ->
            PaginaPilotosUIState(
                id = piloto.id,
                name = piloto.name,
                team = piloto.team.name,
                wins = piloto.wins,
                podiums = piloto.podiums,
                poles = piloto.poles
            )
        }
    }

    fun getPilotoById(id: String): PilotoDTO? {
        return repository.getPilotoById(id)
    }
}

