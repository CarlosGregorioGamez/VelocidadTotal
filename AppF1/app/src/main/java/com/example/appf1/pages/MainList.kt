package com.example.appf1.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.components.CardComponent
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.SliderComponent
import com.example.appf1.components.TitleComponent

/**
 * Página que muestra un listado de tarjetas con información, en una lazycolumn para poder scrollear libremente
 *
 * @param options recibe una lista de Tarjetas reutilizable
 * @param Mensaje de texto que aparce como titulo de la pagina
 */
@Composable
fun MainList(racesList: List<CardSliderDetails> = emptyList(), drivers: List<CardSliderDetails> = emptyList(), teams: List<CardSliderDetails> = emptyList(), titlePage: String, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    )
    {
        Column(
            modifier = modifier
                .height(height = 500.dp)
                .width(width = 275.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           TitleComponent(titlePage)
            LazyColumn {
                item{
                    SliderComponent(cardsInfo = racesList)
                    SliderComponent(cardsInfo = drivers)
                    SliderComponent(cardsInfo = teams)
                }
            }
        }
    }
}

fun racesList(): List<CardSliderDetails> {
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
}

@Preview
@Composable
fun MainListPreview() {
    MainList(emptyList(), emptyList(), emptyList(), "Titulo")
}