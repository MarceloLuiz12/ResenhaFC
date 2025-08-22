package dev.marcelo.resenha.feature_auth.navigation

import kotlinx.serialization.Serializable

sealed class AuthRoutes {
    @Serializable
    data object Login

    @Serializable
    data object Register
}