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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.components.CustomButton
import com.example.compose.backgroundLight

/**
 * Página para el inicio de la aplicacion donde se registrará el usuario
 */
@Composable
fun pagePrincipal() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.formula1),
            contentDescription = "Logo principal de la App"
        )
        Text(text = stringResource(id = R.string.user_name), modifier = Modifier, backgroundLight)
        TextField(
            "",
            onValueChange = {

            },
            modifier = Modifier.padding(9.dp)
        )
        Text(text = stringResource(id = R.string.password_name), modifier = Modifier, backgroundLight)
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
            CustomButton(stringResource(id = R.string.confirm_button)) {

            }
            CustomButton(stringResource(id = R.string.exit_button)) {

            }
        }
    }
}

@Preview
@Composable
fun pagePreview() {
    pagePrincipal(

    )
}