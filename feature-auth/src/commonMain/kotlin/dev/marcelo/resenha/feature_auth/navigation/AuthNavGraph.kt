package dev.marcelo.resenha.feature_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marcelo.resenha.feature_auth.login.LoginScreen

fun NavGraphBuilder.authNavGraph() {
    composable<AuthRoutes.Login> {
        LoginScreen()
    }
}