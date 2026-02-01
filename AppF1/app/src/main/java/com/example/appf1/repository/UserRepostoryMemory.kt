package com.example.appf1.repository

import com.example.appf1.model.UserDTO

class UserRepostoryMemory : UserRepository {

    private val users: ArrayList<UserDTO> = ArrayList()

    companion object{
        val usuarios = ArrayList<UserDTO>(
            listOf(
                UserDTO(0, "Estudiante 1", "Taller 10"),
                UserDTO(1, "Estudiante 2", "Taller 10"),
                UserDTO(2, "Estudiante 3", "Taller 10"),
                UserDTO(3, "Estudiante 4", "Taller 10")
            ))
        var currId = 4
    }

    constructor() {
        for (i in 1..10) {
            users.add(
                UserDTO(
                    id = i,
                    email = "user$i@example.com",
                    password = "password$i",
                )
            )
        }
    }

    override fun getUser(
        id: Int,
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

    override fun login(
        email: String,
        password: String,
        onError: (Throwable) -> Unit,
        onSuccess: (UserDTO) -> Unit
    ) {
        val user = users.find { it.email == email && it.password == password }
        if (user != null) {
            onSuccess(user)
        } else {
            onError(Throwable("User not found"))
        }
    }


}