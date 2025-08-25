package dev.marcelo.resenha.di

import dev.marcelo.resenha.core_networking.di.NetworkModule.netWorkModule
import dev.marcelo.resenha.data.auth.di.dataModule
import dev.marcelo.resenha.domain.auth.di.domainModule
import dev.marcelo.resenha.feature_auth.di.authModule
import org.koin.dsl.module

val appModule = module {
    includes(
        authModule,
        netWorkModule,
        dataModule,
        domainModule
    )
}