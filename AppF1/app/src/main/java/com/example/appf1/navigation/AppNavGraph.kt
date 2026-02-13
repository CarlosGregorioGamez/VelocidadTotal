package com.example.appf1.navigation

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appf1.pages.MainMenu
import com.example.appf1.pages.pageCarreras
import com.example.appf1.pages.pageEquipos
import com.example.appf1.pages.pagePerfil
import com.example.appf1.pages.pagePilotos
import com.example.appf1.pages.pagePrincipal

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

    NavHost(
        navController = navController,
    startDestination = Routes.LOGIN,
        modifier = modifier
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

        //Este es el bueno
        composable(Routes.MAIN_MENU) {
            MainMenu(
                onRaceNav = {id ->
                    navController.navigate("${Routes.RACE_DETAIL}/$id")
                },
                onPilotNav = { id ->
                    navController.navigate("${Routes.PILOT_DETAIL}/$id")
                },
                onTeamNav = {id ->
                    navController.navigate("${Routes.TEAM_DEATIL}/$id")
                }
            )
        }
        composable(
            route = "${Routes.PILOT_DETAIL}/{pilotId}"
        ) { backStackEntry ->
            val pilotId = backStackEntry.arguments?.getString("pilotId") ?: ""
            pagePilotos(
                pilotId
            )
        }
        composable(
            route = "${Routes.RACE_DETAIL}/{raceId}"
        ) { backStackEntry ->
            val raceId = backStackEntry.arguments?.getString("raceId") ?: ""
            pageCarreras(
                raceId
            )
        }

        composable(
            route = "${Routes.TEAM_DEATIL}/{teamId}"
        ) { backStackEntry ->
            val teamId = backStackEntry.arguments?.getString("teamId") ?: ""
            pageEquipos(
                teamId
            )
        }

        composable(Routes.PERFIL) {
            pagePerfil(onBackAction = {
                if (!navController.popBackStack()) {
                    Toast.makeText(context, "No se puede volver atras", Toast.LENGTH_LONG).show();
                }
            })
        }
    }
}



