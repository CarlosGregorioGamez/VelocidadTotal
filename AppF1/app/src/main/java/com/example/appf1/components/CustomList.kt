package com.example.appf1.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appf1.model.PilotoDTO


class Detalle(var name: String, var team: String)

/**
 * Componente que define una lista reutilizable (posible que tenga otra lista similar mas especifica)
 *
 * @param detalles define una lista de elementos
 */
@Composable
fun CustomList(driver: List<PilotoDTO>) {
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
        PilotoDTO("ooo", "aaa", "aa"),
        PilotoDTO("1", "2", "ab"),
        PilotoDTO("3", "4", "ba")
    )

    CustomList(drivers)
}