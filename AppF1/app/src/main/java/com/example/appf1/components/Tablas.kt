package com.example.appf1.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.onSurfaceLight

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState

@Composable
fun TablaSimple(
    cabecera: List<String>,
    filas: List<List<String>>
) {
    val horizontalScrollState = rememberScrollState()

    // Agrupar filas en bloques de 5
    val grupos = filas.chunked(5)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(1.dp, onSurfaceLight, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        // Cabecera
        Row {
            cabecera.forEach { titulo ->
                Text(
                    text = titulo,
                    color = onSurfaceLight,
                    modifier = Modifier
                        .width(120.dp)
                        .padding(end = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Slider horizontal
        Row(
            modifier = Modifier
                .horizontalScroll(horizontalScrollState)
        ) {

            grupos.forEach { grupo ->
                Box(
                    modifier = Modifier
                        .width((120.dp + 8.dp) * cabecera.size)
                        .padding(end = 24.dp)
                ) {

                    Column {
                        grupo.forEach { fila ->
                            Row {
                                fila.forEach { celda ->
                                    Text(
                                        text = celda,
                                        color = onSurfaceLight,
                                        modifier = Modifier
                                            .width(120.dp)
                                            .padding(end = 8.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun PreviewTablaCarreras() {
    val filas = (1..30).map { i ->
        listOf("Gran Premio $i", "Temporada ${2020 + i}")
    }

    TablaSimple(
        cabecera = listOf("Gran Premio", "Año"),
        filas = filas
    )
}



