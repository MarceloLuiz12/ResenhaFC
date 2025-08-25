package dev.marcelo.resenha.data.auth.service

import dev.marcelo.resenha.core_networking.handler_error.GenericResponse
import dev.marcelo.resenha.core_networking.handler_error.safeRequest
import dev.marcelo.resenha.data.auth.model.AddressResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.url

class GetAddressServiceImpl(
    private val client: HttpClient
): GetAddressService {
    override suspend fun getAddress(cep: String): GenericResponse<AddressResponse> =
        client.safeRequest{
            url("https://viacep.com.br/ws/$cep/json/")
        }
}