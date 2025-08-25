package dev.marcelo.resenha.feature_auth.di

import dev.marcelo.resenha.feature_auth.login.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authModule = module {
    viewModelOf(::LoginViewModel)
}