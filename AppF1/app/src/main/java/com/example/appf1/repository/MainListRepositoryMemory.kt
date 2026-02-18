package com.example.appf1.repository

import com.example.appf1.R
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.data.model.CarreraDTO
import com.example.appf1.data.model.EquipoDTO
import com.example.appf1.data.model.PilotoDTO

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
            "E01" to EquipoDTO("E01", "Alpine", listOf("P19", "P14"), 2, 21, 59, R.drawable.alpine),
            "E02" to EquipoDTO("E02", "Aston Martin", listOf("P06", "P07"), 0, 1, 9, R.drawable.aston_martin),
            "E03" to EquipoDTO("E03", "Audi", listOf("P02", "P15"), 2, 27, 80, R.drawable.audi),
            "E04" to EquipoDTO("E04", "Haas", listOf("P18", "P21"), 0, 2, 7, R.drawable.haas),
            "E05" to EquipoDTO("E05", "Ferrari", listOf("P09", "P04"), 16, 243, 800, R.drawable.ferrari),
            "E06" to EquipoDTO("E06", "Racing Bulls", listOf("P10", "P20"), 0, 6, 10, R.drawable.racing_bulls),
            "E07" to EquipoDTO("E07", "McLaren", listOf("P11", "P16"), 8, 183, 500, R.drawable.mclaren),
            "E08" to EquipoDTO("E08", "Mercedes", listOf("P13", "P17"), 8, 125, 300, R.drawable.mercedes),
            "E09" to EquipoDTO("E09", "Cadillac", listOf("P05", "P08"), 1, 7, 14, R.drawable.cadillac),
            "E10" to EquipoDTO("E10", "Red Bull Racing", listOf("P03", "P12"), 6, 120, 250, R.drawable.red_bull_racing),
            "E11" to EquipoDTO("E11", "Williams", listOf("P01", "P22"), 9, 114, 300, R.drawable.williams)
        )

        val carrerasBase = mapOf(
            "C01" to CarreraDTO("C01","GP de Abu Dhabi",1,"Abu Dhabi","P16", listOf("P01","P04"),5.3,R.drawable.abu_dhabi),
            "C02" to CarreraDTO("C02","GP de Arabia Saudi",1,"Arabia Saudí","P12", listOf("P09","P04"),6.1,R.drawable.arabia_saudi),
            "C03" to CarreraDTO("C03","GP de Las Américas",1,"Estados Unidos","P09", listOf("P16","P11"),5.5,R.drawable.austin_usa),
            "C04" to CarreraDTO("C04","GP de Australia",1,"Australia","P11", listOf("P16","P12"),5.3,R.drawable.australia),
            "C05" to CarreraDTO("C05","GP de Austria",1,"Austria","P12", listOf("P11","P09"),4.3,R.drawable.austria),
            "C06" to CarreraDTO("C06","GP de Azerbaijan",1,"Azerbaijan","P09", listOf("P16","P17"),6.0,R.drawable.azerbaijan),
            "C07" to CarreraDTO("C07","GP de Bahrain",1,"Bahrain","P11", listOf("P12","P16"),5.4,R.drawable.bahrein),
            "C08" to CarreraDTO("C08","GP de Bélgica",1,"Bélgica","P12", listOf("P16","P09"),7.0,R.drawable.belgica),
            "C09" to CarreraDTO("C09","GP de Brasil",1,"Brasil","P17", listOf("P11","P16"),4.3,R.drawable.brasil),
            "C10" to CarreraDTO("C10","GP de Canada",1,"Canadá","P16", listOf("P09","P12"),4.4,R.drawable.canada),
            "C11" to CarreraDTO("C11","GP de China",1,"China","P09", listOf("P11","P17"),5.4,R.drawable.china),
            "C12" to CarreraDTO("C12","GP de España",1,"España","P11", listOf("P16","P09"),4.6,R.drawable.espana),
            "C13" to CarreraDTO("C13","GP de Gran Bretaña",1,"Reino Unido","P12", listOf("P09","P16"),5.9,R.drawable.gran_bretana),
            "C14" to CarreraDTO("C14","GP de Hungría",1,"Hungría","P11", listOf("P16","P12"),4.4,R.drawable.hungria),
            "C15" to CarreraDTO("C15","GP de Italia",1,"Italia","P16", listOf("P11","P09"),5.8,R.drawable.italia),
            "C16" to CarreraDTO("C16","GP de Japón",1,"Japón","P12", listOf("P16","P11"),5.8,R.drawable.japon),
            "C17" to CarreraDTO("C17","GP de Mexico",1,"México","P09", listOf("P16","P17"),4.3,R.drawable.mexico),
            "C18" to CarreraDTO("C18","GP de Miami",1,"Estados Unidos","P11", listOf("P12","P16"),5.4,R.drawable.miami),
            "C19" to CarreraDTO("C19","GP de Mónaco",1,"Mónaco","P16", listOf("P09","P11"),3.3,R.drawable.monaco),
            "C20" to CarreraDTO("C20","GP de Países Bajos",1,"Países Bajos","P12", listOf("P11","P16"),4.2,R.drawable.paises_bajos),
            "C21" to CarreraDTO("C21","GP de Qatar",1,"Qatar","P11", listOf("P16","P09"),5.4,R.drawable.qatar),
            "C22" to CarreraDTO("C22","GP de Singapur",1,"Singapur","P09", listOf("P11","P16"),5.0,R.drawable.singapur),
            "C23" to CarreraDTO("C23","GP de Las Vegas",1,"Estados Unidos","P16", listOf("P12","P11"),6.2,R.drawable.vegas)
        )


        val pilotosBase = mapOf(
            "P01" to PilotoDTO("P01","Albon","E11", emptyList(), emptyList(),0,R.drawable.albon),
            "P02" to PilotoDTO("P02","Bortoleto","E03", emptyList(), emptyList(),0,R.drawable.bortoleto),
            "P03" to PilotoDTO("P03","Hadjar","E10", emptyList(), emptyList(),0,R.drawable.hadjar),
            "P04" to PilotoDTO("P04","Leclerc","E05", emptyList(), emptyList(),0,R.drawable.charles),
            "P05" to PilotoDTO("P05","Perez","E09", emptyList(), emptyList(),0,R.drawable.perez),
            "P06" to PilotoDTO("P06","Stroll","E02", emptyList(), emptyList(),0,R.drawable.stroll),
            "P07" to PilotoDTO("P07","Alonso","E02", emptyList(), emptyList(),0,R.drawable.alonso),
            "P08" to PilotoDTO("P08","Bottas","E09", emptyList(), emptyList(),0,R.drawable.bottas),

            "P09" to PilotoDTO(
                "P09","Hamilton","E05",
                listOf("C03","C06","C11","C17","C22"),
                listOf("C02","C05","C08","C10","C12","C13","C15","C19","C21"),
                2,R.drawable.hamilton
            ),

            "P10" to PilotoDTO("P10","Lindblad","E06", emptyList(), emptyList(),0,R.drawable.lindblad),

            "P11" to PilotoDTO(
                "P11","Piastri","E07",
                listOf("C04","C07","C12","C14","C18","C21"),
                listOf("C03","C05","C09","C11","C15","C19","C20","C22","C23"),
                6,R.drawable.piastri
            ),

            "P12" to PilotoDTO(
                "P12","Verstappen","E10",
                listOf("C02","C05","C08","C13","C16","C20"),
                listOf("C04","C07","C10","C14","C18","C23"),
                8,R.drawable.verstappen
            ),

            "P13" to PilotoDTO("P13","Antonelli","E08", emptyList(), emptyList(),0,R.drawable.antonelli),
            "P14" to PilotoDTO("P14","Colapinto","E01", emptyList(), emptyList(),0,R.drawable.colapinto),
            "P15" to PilotoDTO("P15","Hulkenberg","E03", emptyList(), emptyList(),0,R.drawable.hulkenberg),

            "P16" to PilotoDTO(
                "P16","Norris","E07",
                listOf("C01","C10","C15","C19","C23"),
                listOf("C03","C04","C06","C07","C08","C09","C12","C13","C14","C16","C17","C18","C20","C21","C22"),
                7,R.drawable.norris
            ),

            "P17" to PilotoDTO(
                "P17","Russell","E08",
                listOf("C09"),
                listOf("C06","C11","C17"),
                0,R.drawable.russell
            ),

            "P18" to PilotoDTO("P18","Bearman","E04", emptyList(), emptyList(),0,R.drawable.bearman),
            "P19" to PilotoDTO("P19","Gasly","E01", emptyList(), emptyList(),0,R.drawable.gasly),
            "P20" to PilotoDTO("P20","Lawson","E06", emptyList(), emptyList(),0,R.drawable.lawson),
            "P21" to PilotoDTO("P21","Ocon","E04", emptyList(), emptyList(),0,R.drawable.ocon),
            "P22" to PilotoDTO("P22","Sainz","E11", emptyList(), emptyList(),0,R.drawable.sainz)
        )

    }
}