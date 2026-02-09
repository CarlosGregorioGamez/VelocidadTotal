package com.example.appf1.repository

import com.example.appf1.components.CardSliderDetails
import com.example.appf1.repository.MainListRepositoryMemory.Companion.carreras
import com.example.appf1.repository.MainListRepositoryMemory.Companion.equipos
import com.example.appf1.repository.MainListRepositoryMemory.Companion.pilotos

interface MainListRepository {
    fun getRaces(): List<CardSliderDetails> = carreras
    fun getTeams(): List<CardSliderDetails> = equipos
    fun getPilots(): List<CardSliderDetails> = pilotos
}