package com.example.appf1.components

import androidx.compose.runtime.Composable

class Piloto(var name: String, var team: String)

class Carrera(var name: String, var ediciones: Int)

class Equipo(var name: String, var piloto1: Piloto, var  piloto2: Piloto)

@Composable
fun CustomList(pilotos: List<Piloto>){

}

fun CustomListB(carrera: List<Carrera>){

}

fun CustomListC(equipo: List<Equipo>){

}

