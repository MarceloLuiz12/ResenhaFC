package dev.marcelo.resenha.data.auth.di

import dev.marcelo.resenha.data.auth.datasource.GetAddressDataSourceImpl
import dev.marcelo.resenha.data.auth.datasource.GetAddressDataSource
import dev.marcelo.resenha.data.auth.repository.GetAddressRepositoryImpl
import dev.marcelo.resenha.data.auth.service.GetAddressService
import dev.marcelo.resenha.data.auth.service.GetAddressServiceImpl
import dev.marcelo.resenha.domain.auth.repository.GetAddressRepository
import org.koin.dsl.module

val dataModule = module {

    single<GetAddressService>{
        GetAddressServiceImpl(
            client = get()
        )
    }

    single<GetAddressDataSource> {
        GetAddressDataSourceImpl(
            service = get()
        )
    }

    single<GetAddressRepository> {
        GetAddressRepositoryImpl(
            dataSource = get()
        )
    }

}