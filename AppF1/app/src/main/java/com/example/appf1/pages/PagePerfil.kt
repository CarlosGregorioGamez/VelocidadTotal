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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.R
import com.example.appf1.components.CustomButton
import com.example.appf1.components.TitleComponent
import com.example.appf1.repository.UserRepostoryMemory
import com.example.appf1.viewmodel.vm.PerfilVM
import com.example.appf1.viewmodel.vm.PerfilVMFactory
import com.example.compose.backgroundLight

/**
 * Página para poder ver el perfil del usuario activo
 */
@Composable
fun pagePerfil(perfilVM: PerfilVM = viewModel(factory = PerfilVMFactory(UserRepostoryMemory()))){

    val user by perfilVM.uiState.collectAsState()

    Column(
        modifier = Modifier.padding(top = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.perfil),
                contentDescription = "Imagen de perfil",
            )
        }
        Text(text = stringResource(id = R.string.user_name), modifier = Modifier, backgroundLight)
        TextField(
            value = user?.email ?:
            "",
            onValueChange = {
                 perfilVM.updateEmail(it)
            },
            modifier = Modifier.padding(9.dp)
        )
        Text(text = stringResource(id = R.string.password_name), modifier = Modifier, backgroundLight)
        TextField(
            value = user?.password ?:
            "",
            onValueChange = {
                perfilVM.updatePassword(it)
            },
            modifier = Modifier.padding(9.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(stringResource(id = R.string.update_name)) {
                perfilVM.saveChanges()
            }
            CustomButton(stringResource(id = R.string.return_name)) {

            }
        }
    }
}

@Preview
@Composable
fun PerfilPreview() {
    pagePerfil(

    )
}

