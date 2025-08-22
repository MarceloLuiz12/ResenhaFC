package dev.marcelo.resenha.core_networking.di

import dev.marcelo.resenha.core_networking.KtorLogger
import dev.marcelo.resenha.core_networking.di.Network.TIMEOUT
import dev.marcelo.resenha.core_networking.di.NetworkModule.provideKtorHttpClient
import dev.marcelo.resenha.core_networking.handler_error.NetWorkFailure
import dev.marcelo.resenha.core_networking.httpClientEnginePlatform
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.io.IOException
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val netWorkModule = module {
    single {
        provideKtorHttpClient(
            baseUrl = get(QualifierHost)
        )
    }
}

object NetworkModule {
     internal fun provideKtorHttpClient(
        baseUrl: String,
    ): HttpClient {
        return HttpClient(engine = httpClientEnginePlatform()) {
            expectSuccess = false

            install(ContentNegotiation) {
                json(provideJson())
            }

            install(HttpTimeout) {
                socketTimeoutMillis = TIMEOUT
                requestTimeoutMillis = TIMEOUT
                connectTimeoutMillis = TIMEOUT
            }

            defaultRequest {
                url(baseUrl)
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = KtorLogger
            }

            setupResponseValidator()
        }
    }
    private fun provideJson(): Json = Json {
        explicitNulls = false
        ignoreUnknownKeys = true
    }
}

private fun HttpClientConfig<*>.setupResponseValidator() {
    HttpResponseValidator {
        handleResponseExceptionWithRequest { cause, _ ->
            throw when (cause) {
                is ClientRequestException -> NetWorkFailure.GenericError(
                    codeStatus = cause.response.status.value
                )
                is IOException -> NetWorkFailure.NetworkError(
                    codeStatus = NetworkError.Network.code
                )
                else -> NetWorkFailure.GenericError(
                    codeStatus = NetworkError.InternalServerError.code
                )
            }
        }
    }
}

internal object Network {
    const val TIMEOUT = 10000L
}

sealed class NetworkError(val code: Int) {
    data object Network : NetworkError(-1)
    data object InternalServerError : NetworkError(500)
}