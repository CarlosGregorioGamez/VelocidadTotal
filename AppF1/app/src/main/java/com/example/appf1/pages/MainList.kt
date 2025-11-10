package com.example.appf1.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appf1.components.CardComponent
import com.example.appf1.components.CardDetails
import com.example.appf1.components.TitleComponent

/**
 * Página que muestra un listado de tarjetas con información, en una lazycolumn para poder scrollear libremente
 *
 * @param options recibe una lista de Tarjetas reutilizable
 * @param Mensaje de texto que aparce como titulo de la pagina
 */
@Composable
fun MainList(options: List<CardDetails>, titlePage: String, modifier: Modifier = Modifier){
    Column(modifier = Modifier.height(height = 500.dp)
        .width(width = 275.dp)) {
        TitleComponent(titlePage)
        LazyColumn {
            options.forEach {
                item {
                    CardComponent(
                        cardInfo = it
                    )
                }
            }
        }
    }
}