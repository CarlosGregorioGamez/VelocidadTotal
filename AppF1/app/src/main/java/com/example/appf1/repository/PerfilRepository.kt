package com.example.appf1.repository

import com.example.appf1.data.model.UserDTO


interface PerfilRepository {
    fun getUser(id: Int, onError: (Throwable) -> Unit, onSuccess: (UserDTO) -> Unit)

}