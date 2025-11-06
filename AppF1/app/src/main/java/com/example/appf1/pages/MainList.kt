package com.example.appf1.pages

import androidx.compose.foundation.layout.Column
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
 *
 */
@Composable
fun MainList(options: List<CardDetails>, titlePage: String){
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