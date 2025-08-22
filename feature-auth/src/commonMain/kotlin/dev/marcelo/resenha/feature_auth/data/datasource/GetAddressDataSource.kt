package dev.marcelo.resenha.feature_auth.data.datasource

import dev.marcelo.resenha.core_networking.handler_error.toFlow
import dev.marcelo.resenha.feature_auth.data.model.AddressResponse
import dev.marcelo.resenha.feature_auth.data.service.GetAddressService
import kotlinx.coroutines.flow.Flow

interface GetAddressDataSource {
    suspend fun  getAddress(cep: String): Flow<AddressResponse>
}

class GetAddressDataSourceImpl(
    private val service: GetAddressService
): GetAddressDataSource {
    override suspend fun getAddress(cep: String): Flow<AddressResponse> =
        service.getAddress(cep)
            .toFlow()
}