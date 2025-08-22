package dev.marcelo.resenha.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.marcelo.resenha.components.LottieComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import resenhafc.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen(
    onAnimationFinished: () -> Unit
) {
    var lottieAnimationString: String? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(Unit) {
        lottieAnimationString = Res.readBytes(
            "files/lottie/logo.json"
        ).decodeToString()
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            lottieAnimationString?.let {
                LottieComponent(
                    jsonString = it,
                    modifier = Modifier
                        .fillMaxSize(),
                    onAnimationFinished = onAnimationFinished
                )
            }
        }
    }
}
