package dev.marcelo.resenha.feature_auth.data.repository

import dev.marcelo.resenha.feature_auth.data.datasource.GetAddressDataSource
import dev.marcelo.resenha.feature_auth.data.model.AddressResponse
import dev.marcelo.resenha.feature_auth.data.service.GetAddressService
import dev.marcelo.resenha.feature_auth.domain.model.AddressModel
import kotlinx.coroutines.flow.Flow

interface GetAddressRepository {
    suspend fun  getAddress(cep: String): Flow<AddressResponse>
}

class GetAddressRepositoryImpl(
    private val dataSource: GetAddressDataSource
): GetAddressRepository {

    override suspend fun getAddress(cep: String): Flow<AddressResponse> =
        dataSource.getAddress(cep)
}