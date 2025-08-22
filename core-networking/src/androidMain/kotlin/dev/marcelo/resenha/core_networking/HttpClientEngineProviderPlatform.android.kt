package dev.marcelo.resenha.core_networking

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine

actual fun httpClientEnginePlatform() : HttpClientEngine = OkHttpEngine(OkHttpConfig())