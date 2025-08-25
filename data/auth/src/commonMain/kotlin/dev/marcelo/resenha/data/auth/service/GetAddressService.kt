package dev.marcelo.resenha.data.auth.service

import dev.marcelo.resenha.core_networking.handler_error.GenericResponse
import dev.marcelo.resenha.data.auth.model.AddressResponse

interface GetAddressService {
    suspend fun getAddress(cep: String): GenericResponse<AddressResponse>
}