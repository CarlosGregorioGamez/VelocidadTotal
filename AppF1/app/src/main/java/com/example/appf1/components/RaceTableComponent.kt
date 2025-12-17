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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Alignment

@Composable
fun RaceTableComponent(
    header: List<String>,
    rows: List<List<String>>,
) {
    Column {
        Row {
            tituloTabla(header)
        }

        Row {
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(12.dp)
                    .border(1.dp, onSurfaceLight, RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                rows.forEach { data ->
                    item {
                        filaTabla(data, header)
                    }

                }
            }
        }
    }

    // Agrupar filas en bloques de 5

}

@Composable
fun tituloTabla(header: List<String>){

    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        header.forEach { titulo ->
            Column( modifier = Modifier
                .weight(1f)
                .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = titulo,
                    color = onSurfaceLight,
                    modifier = Modifier
                        .padding(8.dp),
                )
            }

        }
    }

}

@Composable
fun filaTabla(data: List<String>, header: List<String>){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        data.forEach { d ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = d,
                    color = onSurfaceLight,
                    modifier = Modifier
                        .padding(end = 8.dp)
                )


                Spacer(modifier = Modifier.height(4.dp))
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRaceTableComponent() {
    val filas = (1..5).map { i ->
        listOf("Gran Premio $i", "Temporada ${2020 + i}")
    }

    RaceTableComponent(
        header = listOf("Gran Premio", "Año"),
        rows = filas
    )
}




