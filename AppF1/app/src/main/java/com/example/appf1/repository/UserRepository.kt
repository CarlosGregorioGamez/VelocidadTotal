package com.example.appf1.repository

import com.example.appf1.data.model.UserDTO


interface UserRepository {
    fun getUser(id: String, onError: (Throwable) -> Unit, onSuccess: (UserDTO) -> Unit)

}