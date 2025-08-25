package dev.marcelo.resenha.domain.auth.repository

import dev.marcelo.resenha.domain.auth.model.AddressModel
import kotlinx.coroutines.flow.Flow

interface GetAddressRepository {
    suspend fun  getAddress(cep: String): Flow<AddressModel>
}