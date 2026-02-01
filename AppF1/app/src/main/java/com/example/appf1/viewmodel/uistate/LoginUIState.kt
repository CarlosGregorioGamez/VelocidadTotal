package com.example.appf1.viewmodel.uistate
data class ListaUsuariosUiState(var usuarios: List <UsuarioUIState> = ArrayList())

data class UsuarioUIState (var id : Int, var email : String, var  password : String)
