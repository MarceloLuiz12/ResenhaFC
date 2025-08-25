package dev.marcelo.resenha.data.auth.repository

import dev.marcelo.resenha.data.auth.datasource.GetAddressDataSource
import dev.marcelo.resenha.domain.auth.model.AddressModel
import dev.marcelo.resenha.domain.auth.repository.GetAddressRepository
import kotlinx.coroutines.flow.Flow

class GetAddressRepositoryImpl(
    private val dataSource: GetAddressDataSource
): GetAddressRepository {

    override suspend fun getAddress(cep: String): Flow<AddressModel> =
        dataSource.getAddress(cep)
}