package dev.marcelo.resenha.di

import dev.marcelo.resenha.core_networking.di.netWorkModule
import dev.marcelo.resenha.feature_auth.di.authModule
import org.koin.dsl.module

val appModule = module {
    includes(
        authModule,
        netWorkModule
    )
}