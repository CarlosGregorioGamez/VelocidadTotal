package com.example.appf1.viewmodel.vm

import androidx.lifecycle.ViewModel
import com.example.appf1.repository.PilotoRepostoryMemory
import com.example.appf1.viewmodel.uistate.PaginaPilotosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class PaginaPilotosVM : ViewModel() {
    private val _uiState = MutableStateFlow<List<PaginaPilotosUIState>>(emptyList())
    private val _repo = PilotoRepostoryMemory()

    val uiState: StateFlow<List<PaginaPilotosUIState>> = _uiState.asStateFlow()

    fun cargarPilotos() {

    }

    /*fun carrerasPilotoList(): List<Piloto> {
        return listOf(
            CardSliderDetails(imgId = R.drawable.abu_dhabi, title = "GP de Abu Dhabi"),
            CardSliderDetails(imgId = R.drawable.arabia_saudi, title = "GP de Arabia Saudí"),
            CardSliderDetails(imgId = R.drawable.austin_usa, title = "GP de las Américas"),
            CardSliderDetails(imgId = R.drawable.australia, title = "Gp de Australia"),
            CardSliderDetails(imgId = R.drawable.austria, title = "GP de Austria"),
            CardSliderDetails(imgId = R.drawable.azerbaijan, title = "GP de Azerbaijan"),
            CardSliderDetails(imgId = R.drawable.bahrein, title = "GP de Bahrain"),
            CardSliderDetails(imgId = R.drawable.belgica, title = "GP de Bélgica"),
            CardSliderDetails(imgId = R.drawable.brasil, title = "GP de Brasil"),
            CardSliderDetails(imgId = R.drawable.canada, title = "GP de Canadá"),
            CardSliderDetails(imgId = R.drawable.china, title = "GP de China"),
            CardSliderDetails(imgId = R.drawable.espana, title = "GP de España"),
            CardSliderDetails(imgId = R.drawable.gran_bretana, title = "GP de Gran Bretaña"),
            CardSliderDetails(imgId = R.drawable.hungria, title = "GP de Hungría"),
            CardSliderDetails(imgId = R.drawable.italia, title = "GP de Italia"),
            CardSliderDetails(imgId = R.drawable.japon, title = "GP de Japón"),
            CardSliderDetails(imgId = R.drawable.mexico, title = "GP de México"),
            CardSliderDetails(imgId = R.drawable.miami, title = "GP de Miami"),
            CardSliderDetails(imgId = R.drawable.monaco, title = "GP de Mónaco"),
            CardSliderDetails(imgId = R.drawable.paises_bajos, title = "GP de Países Bajos"),
            CardSliderDetails(imgId = R.drawable.qatar, title = "GP de Qatar"),
            CardSliderDetails(imgId = R.drawable.singapur, title = "GP de Singapur"),
            CardSliderDetails(imgId = R.drawable.vegas, title = "GP de Las Vegas"),
        )
    }*/


}