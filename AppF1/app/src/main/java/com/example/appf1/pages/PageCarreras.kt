package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.components.CustomButton
import com.example.compose.backgroundLight
import com.example.compose.onPrimaryLight
import com.example.compose.primaryLight

/**
 * Página para ver los datos en detalle de una carrera en específico
 *
 * @param nombreCarrera
 * @param ediciones nº de veces que se ha realizado esta carrera
 * @param curvas nº de curvas
 * @param pais
 */
@Composable
fun pageCarrearas(nombreCarrera: String, ediciones: Int, curvas: Int, pais: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.vegas),
            contentDescription = "Logo principal de la App"
        )
        Text(text = "Carrera :$nombreCarrera", modifier = Modifier, onPrimaryLight)
        Text(text = "Ediciones : $ediciones", modifier = Modifier, onPrimaryLight)
        Text(text = "Numero de curvas : $curvas", modifier = Modifier, onPrimaryLight)
        Text(text = "Pais : $pais", modifier = Modifier, onPrimaryLight)
    }
}

@Preview
@Composable
fun pagePreview1() {
   pageCarrearas("vegas",1,1,"MuricaLand")
}