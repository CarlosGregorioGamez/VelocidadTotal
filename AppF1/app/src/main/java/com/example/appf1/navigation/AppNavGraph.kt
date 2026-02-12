package com.example.appf1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appf1.pages.MainMenu
import com.example.appf1.pages.pagePerfil
import com.example.appf1.pages.pagePilotos
import com.example.appf1.pages.pagePrincipal

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            pagePrincipal(
                onLoginSuccess = {
                    navController.navigate(Routes.MAIN_MENU) {
                        popUpTo(Routes.LOGIN)
                    }
                }
            )
        }
        composable(Routes.MAIN_MENU) {
            MainMenu(
                titlePage = "Menú principal",
                navController = navController
            )
        }
        composable(
            route = "${Routes.PILOT_DETAIL}/{pilotId}"
        ) { backStackEntry ->

            val pilotId = backStackEntry.arguments?.getString("pilotId") ?: ""

            pagePilotos(
                pilotId = pilotId
            )
        }
        composable(Routes.PERFIL) {
            pagePerfil()
        }
    }
}



