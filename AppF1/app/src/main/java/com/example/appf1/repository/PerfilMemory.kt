package com.example.appf1.repository

import com.example.appf1.model.UserDTO

class PerfilMemory : PerfilRepository{

    private val users: ArrayList<UserDTO> = ArrayList()

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

}