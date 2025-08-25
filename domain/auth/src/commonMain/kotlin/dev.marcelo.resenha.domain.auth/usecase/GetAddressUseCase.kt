package dev.marcelo.resenha.domain.auth.usecase

import dev.marcelo.resenha.domain.auth.repository.GetAddressRepository
import dev.marcelo.resenha.domain.auth.model.AddressModel
import kotlinx.coroutines.flow.Flow

interface GetAddressUseCase {
    suspend operator fun invoke(cep: String): Flow<AddressModel>
}

class GetAddressUseCaseImpl(
    private val repository: GetAddressRepository
): GetAddressUseCase {
    override suspend fun invoke(cep: String) =
        repository.getAddress(cep)
}