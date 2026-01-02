package com.example.appf1.repository

import com.example.appf1.model.UserDto

interface UserRepository {
        fun getUser(id: Int, onError: (Throwable) -> Unit, onSuccess: (UserDto) -> Unit)
        fun login(email: String, password: String, onError: (Throwable) -> Unit, onSuccess: (UserDto) -> Unit)
}