package com.example.appf1.pages

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R
import com.example.appf1.viewmodel.vm.LoginVM
import com.example.appf1.components.CustomButton
import com.example.appf1.components.LoginComponent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appf1.repository.UserRepostoryMemory
import com.example.appf1.viewmodel.vm.LoginVMFactory


/**
 * Página para el inicio de la aplicacion donde se registrará el usuario
 */
@Composable
fun pagePrincipal( loginVM: LoginVM = viewModel(
    factory = LoginVMFactory(
        repository = UserRepostoryMemory()
    )
),
    onLoginSuccess: () -> Unit
) {

    val uiState by loginVM.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.formula1),
            contentDescription = "Logo principal de la App"
        )

        LoginComponent(
            email = uiState.email,
            password = uiState.password,
            onEmailChange = { loginVM.onEmailChange(it) },
            onPasswordChange = { loginVM.onPasswordChange(it) }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomButton(stringResource(id = R.string.confirm_button)) {
                loginVM.login {
                    Log.d("LOGIN CORRECTO","si si")
                    onLoginSuccess()
                }
            }
            CustomButton(stringResource(id = R.string.exit_button)) {
                // salir
            }
        }
    }
}


