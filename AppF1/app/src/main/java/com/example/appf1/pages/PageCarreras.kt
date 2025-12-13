package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.components.CustomButton
import com.example.compose.backgroundLight
import com.example.compose.onPrimaryLight
import com.example.compose.primaryLight
import com.example.compose.surfaceContainerLight

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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,        // centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // centra horizontalmente
    ) {
        Card(
            modifier = Modifier
                .padding(24.dp)
                .height(400.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = surfaceContainerLight
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.vegas),
                    contentDescription = "Logo principal de la App"
                )
                Text(
                    text = stringResource(id = R.string.object_name) + " : $nombreCarrera",
                    modifier = Modifier,
                    onPrimaryLight
                )
                Text(
                    text = stringResource(id = R.string.editions_name) + " : $ediciones",
                    modifier = Modifier,
                    onPrimaryLight
                )
                Text(
                    text = stringResource(id = R.string.turns_name) + " : $curvas",
                    modifier = Modifier,
                    onPrimaryLight
                )
                Text(
                    text = stringResource(id = R.string.country_name) + " : $pais",
                    modifier = Modifier,
                    onPrimaryLight
                )
            }
        }
    }
}


@Preview
@Composable
fun pagePreview1() {
   pageCarrearas("vegas",1,1,"MuricaLand")
}