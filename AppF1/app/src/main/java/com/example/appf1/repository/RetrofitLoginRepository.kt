package com.example.appf1.repository

import android.content.Context
import com.example.appf1.data.model.UserDTO
import com.example.appf1.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitLoginRepository(private val context: Context): UserRepository {

    private val apiUser = RetrofitClient.usuariosApiService

    override fun getUser(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDTO) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val userResponse = apiUser.getUser(id)

                if (userResponse.isSuccessful) {
                    val user = userResponse.body()
                    if (user != null) {
                        onSuccess(UserDTO(user.id, user.email, user.passwd))
                    }
                } else {
                    onError(Exception("HTTP ${userResponse.code()}"))
                }
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}