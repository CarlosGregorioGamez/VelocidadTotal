package com.example.appf1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.appf1.R

data class Login(val email: String="", val contrasenha: String="")


@Composable
fun LoginComponent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column {
        Text(text = "Usuario")
        TextField(
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier.padding(8.dp)
        )

        Text(text = "Contraseña")
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(8.dp)
        )
    }
}
