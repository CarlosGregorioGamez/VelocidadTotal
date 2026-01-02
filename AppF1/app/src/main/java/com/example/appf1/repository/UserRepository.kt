package com.example.appf1.repository

import com.example.appf1.model.UserDTO


interface UserRepository {
    fun getUser(id: Int, onError: (Throwable) -> Unit, onSuccess: (UserDTO) -> Unit)
    fun login(
        email: String,
        password: String,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDTO) -> Unit
    )
}