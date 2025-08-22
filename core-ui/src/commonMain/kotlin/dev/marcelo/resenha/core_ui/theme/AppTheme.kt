package dev.marcelo.resenha.core_ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import dev.marcelo.resenha.core_ui.resources.Colors

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = isDarkTheme.getColorScheme(),
        content = content,
    )
}

private fun Boolean.getColorScheme() =
    if (this){
        Colors.DarkColors
    } else {
        Colors.LightColors
    }