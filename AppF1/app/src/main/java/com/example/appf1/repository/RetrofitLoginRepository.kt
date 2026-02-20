package com.example.appf1.repository

import android.content.Context
import com.example.appf1.data.model.UserDTO
import com.example.appf1.remote.RetrofitClient
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
                    if (user != null) {
                        withContext(Dispatchers.Main) {
                            onSuccess(UserDTO(user.id, user.email, user.passwd))
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onError(Exception("HTTP ${userResponse.code()}"))
                    }
                }
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}