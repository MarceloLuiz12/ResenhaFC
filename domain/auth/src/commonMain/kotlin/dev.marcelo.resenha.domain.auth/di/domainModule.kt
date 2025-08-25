package dev.marcelo.resenha.domain.auth.di

import dev.marcelo.resenha.domain.auth.usecase.GetAddressUseCase
import dev.marcelo.resenha.domain.auth.usecase.GetAddressUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetAddressUseCase> {
        GetAddressUseCaseImpl(
            repository = get()
        )
    }
}