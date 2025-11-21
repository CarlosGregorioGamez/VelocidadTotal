package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceContainerLight

/**
 * Página para ver los datos en detalle de un piloto en específico
 *
 * @param nombrePiloto
 * @param apellidos
 * @param equipo
 * @param carrerasCorridas nº de carrera en las que particico
 * @param victorias
 * @param poles
 */
@Composable
fun pageEquipos(
    nombrePiloto1: String,
    nombrePiloto2: String,
    equipo: String,
    liderEquipo: String,
    victorias: Int,
    poles: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,        // centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // centra horizontalmente
    ){
        Card(
            modifier = Modifier
                .padding(24.dp)
                .height(400.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = surfaceContainerLight
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ferrari),
                    contentDescription = "Foto de $equipo",
                    modifier = Modifier.size(180.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Nombre :$equipo", modifier = Modifier, onSurfaceLight)
                Text(text = "Nombre pilotos : $nombrePiloto1 , $nombrePiloto2", modifier = Modifier, onSurfaceLight)
                Text(text = "Lider equipo : $liderEquipo", modifier = Modifier, onSurfaceLight)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Victorias : $victorias", modifier = Modifier, onSurfaceLight)
                Text(text = "Poles : $poles", modifier = Modifier, onSurfaceLight)
            }
        }
    }
}

@Preview
@Composable
fun pagePreviewE() {
    pageEquipos("Piloto 1", "ni idea", "alguno", "doku", 3, 1)
}