package dev.marcelo.resenha.data.auth.remote.datasource

import dev.marcelo.resenha.domain.auth.model.AddressModel
import kotlinx.coroutines.flow.Flow

interface GetAddressDataSource {
    suspend fun  getAddress(cep: String): Flow<AddressModel>
}