package dev.marcelo.resenha.data.auth.remote.datasource

import dev.marcelo.resenha.core_networking.handler_error.toFlow
import dev.marcelo.resenha.data.auth.remote.service.GetAddressService
import dev.marcelo.resenha.domain.auth.model.AddressModel
import dev.marcelo.resenha.data.auth.remote.mapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAddressDataSourceImpl(
    private val service: GetAddressService
): GetAddressDataSource {
    override suspend fun getAddress(cep: String): Flow<AddressModel> {
        val response = service.getAddress(cep).toFlow()
        return response.map { response ->
            response.toModel()
        }
    }
}