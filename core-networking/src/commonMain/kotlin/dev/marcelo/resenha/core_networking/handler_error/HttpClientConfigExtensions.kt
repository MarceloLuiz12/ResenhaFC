package dev.marcelo.resenha.core_networking.handler_error

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request

suspend inline fun <reified T> HttpClient.safeRequest(
    block: HttpRequestBuilder.() -> Unit,
): GenericResponse<T> =
    try {
        val response = request { block() }
        GenericResponse.Success(response.body())
    } catch (e: NetWorkFailure) {
        GenericResponse.Error(exception = e)
    }
