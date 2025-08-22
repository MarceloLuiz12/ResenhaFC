package dev.marcelo.resenha.feature_auth.domain.usecase

import dev.marcelo.resenha.feature_auth.data.model.AddressResponse
import dev.marcelo.resenha.feature_auth.data.repository.GetAddressRepository
import kotlinx.coroutines.flow.Flow

interface GetAddressUseCase {
    suspend operator fun invoke(cep: String): Flow<AddressResponse>
}

class GetAddressUseCaseImpl(
    private val repository: GetAddressRepository
): GetAddressUseCase {
    override suspend fun invoke(cep: String) =
        repository.getAddress(cep)
}