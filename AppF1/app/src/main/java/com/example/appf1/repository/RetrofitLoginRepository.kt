package com.example.appf1.repository

import android.content.Context
import com.example.appf1.data.model.UserDTO
import com.example.appf1.remote.RetrofitClient
import com.example.appf1.remote.dto.UsuarioRetroDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RetrofitLoginRepository(private val context: Context) {

    private val apiUser = RetrofitClient.usuariosApiService


    fun getUser(
        email: String,
        passwd: String,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDTO) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val userResponse = apiUser.getAllUsers()
                if (userResponse.isSuccessful) {
                    val user = userResponse.body()
                        ?.firstOrNull { it.email == email && it.passwd == passwd }

                    withContext(Dispatchers.Main) {
                        if (user != null) {
                            onSuccess(UserDTO(user.id, user.email, user.passwd))
                        } else {
                            onError(Exception("Usuario o contraseña incorrectos"))
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onError(Exception("HTTP ${userResponse.code()}"))
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }


    fun updateUser(
        user: UserDTO,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiUser.updateUser(
                    id = user.id,
                    user = UsuarioRetroDTO(
                        id = user.id,
                        email = user.email,
                        passwd = user.password
                    )
                )

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        onSuccess()
                    } else {
                        onError(Exception("HTTP ${response.code()}"))
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }
}