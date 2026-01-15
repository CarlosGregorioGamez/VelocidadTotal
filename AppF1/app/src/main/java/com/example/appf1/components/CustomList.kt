package com.example.appf1.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


class Detalle(var name: String, var team: String)

/**
 * Componente que define una lista reutilizable (posible que tenga otra lista similar mas especifica)
 *
 * @param detalles define una lista de elementos
 */
@Composable
fun CustomList(driver: List<Driver>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        driver.forEach { detalle ->
            pilot(driver = detalle)
        }
    }
}

@Preview
@Composable
fun listaPreview() {
    val drivers = listOf(
        Driver("ooo", "aaa", "aa"),
        Driver("1", "2", "ab"),
        Driver("3", "4", "ba")
    )

    CustomList(drivers)
}