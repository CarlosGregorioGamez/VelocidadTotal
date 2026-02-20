package com.example.appf1.repository

import com.example.appf1.data.model.UserDTO

class UserRepostoryMemory : UserRepository {

    private val users: ArrayList<UserDTO> = ArrayList()

    companion object {
        val usuarios = ArrayList<UserDTO>(
            listOf(
                UserDTO("0", "1@mail.com", "abc123."),
                UserDTO("1", "mail@ejemplo.com", "4321"),
                UserDTO("2", "Pedro@gmail.com", "1234"),
                UserDTO("3", "correo@correo.com", "0000")
            )
        )
        var currId = 4
    }

    constructor() {
        for (i in 1..10) {
            users.add(
                UserDTO(
                    id = i.toString(),
                    email = "user$i@example.com",
                    password = "password$i",
                )
            )
        }
    }

    override fun getUser(
        id: String,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDTO) -> Unit
    ) {
        val user = users.find { it.id == id }
        if (user != null) {
            onSuccess(user)
        } else {
            onError(Throwable("User not found"))
        }
    }

    fun login(
        email: String,
        password: String,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDTO) -> Unit
    ) {
        val user = usuarios.find { it.email == email && it.password == password }
        if (user != null) {
            onSuccess(user)
        } else {
            onError(Throwable("Error en los datos"))
        }
    }
}