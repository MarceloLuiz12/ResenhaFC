package dev.marcelo.resenha.data.auth.remote.service

import dev.marcelo.resenha.core_networking.handler_error.GenericResponse
import dev.marcelo.resenha.data.auth.remote.model.AddressResponse

interface GetAddressService {
    suspend fun getAddress(cep: String): GenericResponse<AddressResponse>
}