package dev.marcelo.resenha.core_networking.handler_error

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
sealed class GenericResponse<out T> {
    @Serializable
    data class Success<out T>(
        val value: T
    ) : GenericResponse<T>()

    @Serializable
    data class Error(
        val body: String? = null,
        @Transient
        val exception: NetWorkFailure? = null
    ) : GenericResponse<Nothing>()
}

fun <T> GenericResponse<T>.toResult(): Result<T> =
    when (this) {
        is GenericResponse.Success -> {
            Result.success(this.value)
        }
        is GenericResponse.Error -> {
            Result.failure(this.exception ?: NetWorkFailure.GenericError())
        }
    }

fun <T> GenericResponse<T>.toFlow(): Flow<T> {
    val networkResponse = this
    return flow {
        when (networkResponse) {
            is GenericResponse.Success -> {
                emit(networkResponse.value)
            }
            is GenericResponse.Error -> {
                throw networkResponse.exception ?: NetWorkFailure.GenericError()
            }
        }
    }
}
