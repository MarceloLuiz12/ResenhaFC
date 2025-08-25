package dev.marcelo.resenha.feature_auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun LoginScreen() {
    val viewModel: LoginViewModel = koinViewModel()
    LaunchedEffect(Unit){
        viewModel.fetchAddress()
    }
    val uiState by viewModel.address.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Screen",
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = uiState,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}