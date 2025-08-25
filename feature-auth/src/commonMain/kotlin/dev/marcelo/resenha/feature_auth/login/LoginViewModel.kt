package dev.marcelo.resenha.feature_auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.marcelo.resenha.core_networking.handler_error.catchFailure
import dev.marcelo.resenha.domain.auth.usecase.GetAddressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getAddressUseCase: GetAddressUseCase
): ViewModel() {

    private val _address = MutableStateFlow("")
    val address = _address.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ""
    )

    fun fetchAddress() {
        viewModelScope.launch {
            getAddressUseCase(
                cep = "88355110"
            ).onStart {
                _address.value = "Loading"
            }.catchFailure{
                _address.value = it.message ?: "Error"
            }.collect{
                _address.value = it.street
            }
        }
    }

}