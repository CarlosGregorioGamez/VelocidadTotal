package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.appf1.R
import com.example.compose.onPrimaryLight

/**
 * Página para ver los datos en detalle de una carrera en específico
 *
 * @param nombrePiloto
 * @param apellidos
 * @param equipo
 * @param carrerasCorridas nº de carrera en las que particico
 * @param victorias
 * @param poles
 */
@Composable
fun pagePilotos(nombrePiloto: String, apellidos: String, equipo: String, carrerasCorridas: Int, victorias: Int, poles: Int) {
    Column(

        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.vegas),
            contentDescription = "Logo principal de la App"
        )
        Text(text = "Nombre :$nombrePiloto", modifier = Modifier, onPrimaryLight)
        Text(text = "Apellidos : $apellidos", modifier = Modifier, onPrimaryLight)
        Text(text = "Equipo : $equipo", modifier = Modifier, onPrimaryLight)
        Text(text = "Carreras : $carrerasCorridas", modifier = Modifier, onPrimaryLight)
        Text(text = "Victorias : $victorias", modifier = Modifier, onPrimaryLight)
        Text(text = "Poles : $poles", modifier = Modifier, onPrimaryLight)
    }
}

@Preview
@Composable
fun pagePreviewP() {
   pagePilotos("Piloto 1","ni idea","alguno",6,3,1)
}