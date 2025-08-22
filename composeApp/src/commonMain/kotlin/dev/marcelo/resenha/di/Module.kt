package dev.marcelo.resenha.di

import dev.marcelo.resenha.feature_auth.di.authModule
import org.koin.dsl.module

val appModule = module {
    includes(
        authModule
    )
}