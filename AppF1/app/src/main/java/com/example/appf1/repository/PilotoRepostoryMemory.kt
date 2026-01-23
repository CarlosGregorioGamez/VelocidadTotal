package com.example.appf1.repository

import com.example.appf1.model.Piloto

class PilotoRepostoryMemory {

    val pilotos: ArrayList<Piloto> = ArrayList();

    init {
        pilotos.add(Piloto("alonso"))
        pilotos.add(Piloto("Sumaker"))

    }

    fun getAll(success: (pilotos: List<Piloto>) -> Unit) {
        success.invoke(pilotos);
    }

}
