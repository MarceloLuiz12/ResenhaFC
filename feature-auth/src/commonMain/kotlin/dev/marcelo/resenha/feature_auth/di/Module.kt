package dev.marcelo.resenha.feature_auth.di

import dev.marcelo.resenha.feature_auth.data.datasource.GetAddressDataSource
import dev.marcelo.resenha.feature_auth.data.datasource.GetAddressDataSourceImpl
import dev.marcelo.resenha.feature_auth.data.repository.GetAddressRepository
import dev.marcelo.resenha.feature_auth.data.repository.GetAddressRepositoryImpl
import dev.marcelo.resenha.feature_auth.data.service.GetAddressService
import dev.marcelo.resenha.feature_auth.data.service.GetAddressServiceImpl
import dev.marcelo.resenha.feature_auth.domain.usecase.GetAddressUseCase
import dev.marcelo.resenha.feature_auth.domain.usecase.GetAddressUseCaseImpl
import dev.marcelo.resenha.feature_auth.login.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authModule = module {

    factory<GetAddressUseCase> {
        GetAddressUseCaseImpl(
            repository = get()
        )
    }

    factory<GetAddressRepository> {
        GetAddressRepositoryImpl(
            dataSource = get()
        )
    }

    factory<GetAddressService>{
        GetAddressServiceImpl(
            client = get()
        )
    }

    factory<GetAddressDataSource> {
        GetAddressDataSourceImpl(
            service = get()
        )
    }

    viewModelOf(::LoginViewModel)

}