package com.example.appf1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.components.CustomButton
import com.example.appf1.components.TitleComponent
import com.example.compose.backgroundLight

@Composable
fun pagePerfil() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.formula1),
            contentDescription = "Logo principal de la App"
        )
        Text(text = "Usuario", modifier = Modifier, backgroundLight)
        TextField(
            "",
            onValueChange = {

            },
            modifier = Modifier.padding(9.dp)
        )
        Text(text = "Contraseña", modifier = Modifier, backgroundLight)
        TextField(
            "",
            onValueChange = {

            },
            modifier = Modifier.padding(9.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton("Iniciar") {

            }
            CustomButton("Salir") {

            }
        }
    }
}

@Preview
@Composable
fun PerfilPreview() {
    pagePrincipal(

    )
}

