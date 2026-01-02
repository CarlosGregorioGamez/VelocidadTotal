package com.example.appf1.navHost

import kotlinx.serialization.Serializable

sealed interface rutasNavegacion {

    @Serializable
    object login : rutasNavegacion
    @Serializable
    class inicio(val id : Int) : rutasNavegacion
    @Serializable
    class carreras(val id : Int) : rutasNavegacion
    @Serializable
    class equipos(val id : Int) : rutasNavegacion
    @Serializable
    class pilotos(val id : Int) : rutasNavegacion
    @Serializable
    class perfil(val id : Int) : rutasNavegacion



}