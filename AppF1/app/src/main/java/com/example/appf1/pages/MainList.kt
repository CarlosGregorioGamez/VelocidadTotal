package com.example.appf1.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun MainList(options: List<CardDetails>, titlePage: String, modifier: Modifier = Modifier) {

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
}