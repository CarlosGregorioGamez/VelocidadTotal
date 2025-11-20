package com.example.appf1.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


class Detalle(var name: String, var detalleList: List <String>)

/**
 * Componente que define una lista reutilizable (posible que tenga otra lista similar mas especifica)
 *
 * @param detalles define una lista de elementos
 */
@Composable
fun CustomList(detalles: List<Detalle>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        detalles.forEach { detalle  ->
            pilot(detalle.name, detalle.detalleList)
        }
    }
}

@Preview
@Composable
fun listaPreview() {
    val detalle = ArrayList<Detalle>()
    detalle.add(Detalle("ooo", "aaa"))
    detalle.add(Detalle("1", "2"))
    detalle.add(Detalle("3", "4"))
    CustomList(detalle)
}