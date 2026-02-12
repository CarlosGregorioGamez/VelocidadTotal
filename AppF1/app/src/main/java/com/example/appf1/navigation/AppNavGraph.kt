package com.example.appf1.navigation

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

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
                }, onexit = {
                    val activity = context as? Activity
                    activity?.finish()
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
            pagePerfil(onBackAction = {

                if(!navController.popBackStack()){
                    Toast.makeText(context, "No se puede volver atras", Toast.LENGTH_LONG).show();
                }
            })
        }
    }
}



