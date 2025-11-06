package com.example.appf1.components


import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun race(name: String, cantidad: Int) {

    val backgroundColor = Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .border(1.dp, color =  Color.Black)
            .padding(all = 4.dp)

    ) {
        Column {
            Text(text = name, modifier = Modifier.fillMaxWidth())
            Text(text = "$cantidad", modifier = Modifier.fillMaxWidth())
        }

    }
}

@Preview
@Composable

fun carreraPreview() {
    race("Barcelona",399)
}

@Preview
@Composable
fun pruebaCarrerasPreview() {
   race("marte",13)
}