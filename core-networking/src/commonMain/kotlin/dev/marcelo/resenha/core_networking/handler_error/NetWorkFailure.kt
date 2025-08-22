package dev.marcelo.resenha.core_networking.handler_error

import kotlinx.serialization.Serializable

@Serializable
sealed class NetWorkFailure(
    val code: Int? = null,
    val errorMassage: String
) : Exception() {
    data class GenericError(
        val codeStatus: Int? = null,
    ) : NetWorkFailure(code = codeStatus, errorMassage = "Ocorreu um erro inesperado.")

    data class NetworkError(
        val codeStatus: Int? = null,
    ) : NetWorkFailure(code = codeStatus, errorMassage = "Verifique sua conexão com a internet.")
}