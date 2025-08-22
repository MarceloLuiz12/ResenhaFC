package dev.marcelo.resenha.core_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.marcelo.resenha.feature_auth.navigation.authNavGraph
import dev.marcelo.resenha.splash.splashNavGraph

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        splashNavGraph(navController)
        authNavGraph()
    }
}