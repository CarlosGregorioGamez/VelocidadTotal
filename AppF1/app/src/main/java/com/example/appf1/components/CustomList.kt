package com.example.appf1.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class Piloto(var name: String, var team: String)

@Composable
fun CustomList(pilotos: List<Piloto>){
    Column(modifier = Modifier.fillMaxWidth()){
        pilotos.forEach{
                Piloto ->
                Piloto(Piloto.name,Piloto.team)
        }
    }
}

@Preview
@Composable
fun listaPreview(){
    val piloto= ArrayList<Piloto>()
    piloto.add(Piloto("ooo", "aaa"))
    piloto.add(Piloto("1", "2"))
    piloto.add(Piloto("3", "4"))

    CustomList(piloto)
}