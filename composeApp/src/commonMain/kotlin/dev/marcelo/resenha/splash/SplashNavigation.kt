package dev.marcelo.resenha.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.marcelo.resenha.core_navigation.Splash
import dev.marcelo.resenha.feature_auth.navigation.AuthRoutes

fun NavGraphBuilder.splashNavGraph(navController: NavHostController) {
    composable<Splash> {
        SplashScreen(
            onAnimationFinished = {
                navController.navigate(
                    route = AuthRoutes.Login
                )
            }
        )
    }
}