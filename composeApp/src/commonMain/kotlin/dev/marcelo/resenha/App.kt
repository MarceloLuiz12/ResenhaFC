package dev.marcelo.resenha

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.marcelo.resenha.di.appModule
import dev.marcelo.resenha.core_navigation.NavigationGraph
import dev.marcelo.resenha.core_ui.theme.AppTheme
import org.koin.compose.KoinApplication

@Composable
fun App() {
    AppTheme {
        KoinApplication(
            application = {
                modules(appModule)
            }
        ) {
            val navController = rememberNavController()
            NavigationGraph(
                navController = navController
            )
        }
    }
}