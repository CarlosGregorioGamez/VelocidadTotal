package com.example.appf1.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.components.CustomButton
import com.example.appf1.components.TitleComponent
import com.example.compose.backgroundLight

@Composable
fun pagePrincipal() {
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "usuario", modifier = Modifier.fillMaxWidth(), backgroundLight)
        TextField(
            "",
            onValueChange = {

            },
            modifier = Modifier.padding(9.dp)
            )
        Text(text = "contraseña", modifier = Modifier.fillMaxWidth(), backgroundLight)
        TextField(
            "",
            onValueChange = {

            },
            modifier = Modifier.padding(9.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Row {
            CustomButton("iniciar") { }
            CustomButton("Salir") { }
        }

    }


}

@Preview
@Composable
fun pagePreview() {
    pagePrincipal(

    )
}