package com.example.appf1.repository

import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.data.model.EquipoDTO

class MainListRepositoryMemory : MainListRepository {

    companion object{

        val carreras = listOf(
            CardSliderDetails(id = "C01", imgId = R.drawable.abu_dhabi, title = "GP de Abu Dhabi"),
            CardSliderDetails(id = "C02", imgId = R.drawable.arabia_saudi, title = "GP de Arabia Saudí"),
            CardSliderDetails(id = "C03", imgId = R.drawable.austin_usa, title = "GP de las Américas"),
            CardSliderDetails(id = "C04", imgId = R.drawable.australia, title = "GP de Australia"),
            CardSliderDetails(id = "C05", imgId = R.drawable.austria, title = "GP de Austria"),
            CardSliderDetails(id = "C06", imgId = R.drawable.azerbaijan, title = "GP de Azerbaijan"),
            CardSliderDetails(id = "C07", imgId = R.drawable.bahrein, title = "GP de Bahrain"),
            CardSliderDetails(id = "C08", imgId = R.drawable.belgica, title = "GP de Bélgica"),
            CardSliderDetails(id = "C09", imgId = R.drawable.brasil, title = "GP de Brasil"),
            CardSliderDetails(id = "C10", imgId = R.drawable.canada, title = "GP de Canadá"),
            CardSliderDetails(id = "C11", imgId = R.drawable.china, title = "GP de China"),
            CardSliderDetails(id = "C12", imgId = R.drawable.espana, title = "GP de España"),
            CardSliderDetails(id = "C13", imgId = R.drawable.gran_bretana, title = "GP de Gran Bretaña"),
            CardSliderDetails(id = "C14", imgId = R.drawable.hungria, title = "GP de Hungría"),
            CardSliderDetails(id = "C15", imgId = R.drawable.italia, title = "GP de Italia"),
            CardSliderDetails(id = "C16", imgId = R.drawable.japon, title = "GP de Japón"),
            CardSliderDetails(id = "C17", imgId = R.drawable.mexico, title = "GP de México"),
            CardSliderDetails(id = "C18", imgId = R.drawable.miami, title = "GP de Miami"),
            CardSliderDetails(id = "C19", imgId = R.drawable.monaco, title = "GP de Mónaco"),
            CardSliderDetails(id = "C20", imgId = R.drawable.paises_bajos, title = "GP de Países Bajos"),
            CardSliderDetails(id = "C21", imgId = R.drawable.qatar, title = "GP de Qatar"),
            CardSliderDetails(id = "C22", imgId = R.drawable.singapur, title = "GP de Singapur"),
            CardSliderDetails(id = "C23", imgId = R.drawable.vegas, title = "GP de Las Vegas")
        )


        val equipos = listOf(
            CardSliderDetails(id = "E01", imgId = R.drawable.alpine, title = "Alpine F1"),
            CardSliderDetails(id = "E02", imgId = R.drawable.aston_martin, title = "Aston Martin F1"),
            CardSliderDetails(id = "E03", imgId = R.drawable.audi, title = "Audi F1"),
            CardSliderDetails(id = "E04", imgId = R.drawable.cadillac, title = "Cadillac F1"),
            CardSliderDetails(id = "E05", imgId = R.drawable.ferrari, title = "Ferrari F1"),
            CardSliderDetails(id = "E06", imgId = R.drawable.haas, title = "Haas F1"),
            CardSliderDetails(id = "E07", imgId = R.drawable.mclaren, title = "McLaren F1"),
            CardSliderDetails(id = "E08", imgId = R.drawable.mercedes, title = "Mercedes AMG F1"),
            CardSliderDetails(id = "E09", imgId = R.drawable.racing_bulls, title = "Visa CashApp Racing Bulls F1"),
            CardSliderDetails(id = "E10", imgId = R.drawable.red_bull_racing, title = "Red Bull Racing F1"),
            CardSliderDetails(id = "E11", imgId = R.drawable.williams, title = "Williams F1")
        )


        val pilotos = listOf(
            CardSliderDetails(id = "P01", imgId = R.drawable.albon, title = "Albon"),
            CardSliderDetails(id = "P02", imgId = R.drawable.bortoleto, title = "Bortoleto"),
            CardSliderDetails(id = "P03", imgId = R.drawable.hadjar, title = "Hadjar"),
            CardSliderDetails(id = "P04", imgId = R.drawable.charles, title = "Leclerc"),
            CardSliderDetails(id = "P05", imgId = R.drawable.perez, title = "Perez"),
            CardSliderDetails(id = "P06", imgId = R.drawable.stroll, title = "Stroll"),
            CardSliderDetails(id = "P07", imgId = R.drawable.alonso, title = "Alonso"),
            CardSliderDetails(id = "P08", imgId = R.drawable.bottas, title = "Bottas"),
            CardSliderDetails(id = "P09", imgId = R.drawable.hamilton, title = "Hamilton"),
            CardSliderDetails(id = "P10", imgId = R.drawable.lindblad, title = "Lindblad"),
            CardSliderDetails(id = "P11", imgId = R.drawable.piastri, title = "Piastri"),
            CardSliderDetails(id = "P12", imgId = R.drawable.verstappen, title = "Verstappen"),
            CardSliderDetails(id = "P13", imgId = R.drawable.antonelli, title = "Antonelli"),
            CardSliderDetails(id = "P14", imgId = R.drawable.colapinto, title = "Colapinto"),
            CardSliderDetails(id = "P15", imgId = R.drawable.hulkenberg, title = "Hulkenberg"),
            CardSliderDetails(id = "P16", imgId = R.drawable.norris, title = "Norris"),
            CardSliderDetails(id = "P17", imgId = R.drawable.russell, title = "Russell"),
            CardSliderDetails(id = "P18", imgId = R.drawable.bearman, title = "Bearman"),
            CardSliderDetails(id = "P19", imgId = R.drawable.gasly, title = "Gasly"),
            CardSliderDetails(id = "P20", imgId = R.drawable.lawson, title = "Lawson"),
            CardSliderDetails(id = "P21", imgId = R.drawable.ocon, title = "Ocon"),
            CardSliderDetails(id = "P22", imgId = R.drawable.sainz, title = "Sainz")
        )

        val equiposBase = mapOf(
            "E01" to EquipoDTO("E01", "Alpine", emptyList(), 2, 21, 59, R.drawable.alpine),
            "E02" to EquipoDTO("E02", "Aston Martin", emptyList(), 0, 1, 9, R.drawable.aston_martin),
            "E03" to EquipoDTO("E03", "Audi", emptyList(), 0, 0, 0, R.drawable.audi),
            "E05" to EquipoDTO("E05", "Ferrari", emptyList(), 16, 243, 800, R.drawable.ferrari),
            "E07" to EquipoDTO("E07", "McLaren", emptyList(), 8, 183, 500, R.drawable.mclaren),
            "E08" to EquipoDTO("E08", "Mercedes", emptyList(), 8, 125, 300, R.drawable.mercedes),
            "E10" to EquipoDTO("E10", "Red Bull Racing", emptyList(), 6, 120, 250, R.drawable.red_bull_racing),
            "E11" to EquipoDTO("E11", "Williams", emptyList(), 9, 114, 300, R.drawable.williams)
        )
    }

}