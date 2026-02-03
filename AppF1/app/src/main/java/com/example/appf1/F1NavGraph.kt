package com.example.appf1

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appf1.Routes.MainMenu
import com.example.appf1.pages.MainMenu
import com.example.appf1.pages.pagePrincipal

object Routes {
    const val MainMenu = "mainMenu"
    const val pageCarreras = "pageCarreras/{Id}"
    const val pageEquipos = "pageEquipos/{Id}"
    const val pageLogin = "pageLogin"
    const val pagePerfil = "pagePerfil/{id}"
    const val pagePilotos = "pagePilotos/{id}"

}

@Composable
fun mainMenuNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.pageLogin) {
        composable(Routes.pageLogin) {
            //MainMenu(titlePage = "nm,")
            pagePrincipal(){
                navController.navigate(Routes.MainMenu)
            }
        }
    }
}

fun PageCarrerasNavGraph(){

}

fun PageEquiposNavGraph(){

}


fun PagePilotosNavGraph(){

}

fun PagePerfilNavGraph(){

}

fun PageLoginNavGraph(){

}
