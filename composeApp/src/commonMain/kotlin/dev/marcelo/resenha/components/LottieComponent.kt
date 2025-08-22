package dev.marcelo.resenha.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun LottieComponent(
    jsonString: String,
    modifier: Modifier = Modifier,
    onAnimationFinished: () -> Unit
)