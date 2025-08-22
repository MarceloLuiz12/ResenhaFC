package dev.marcelo.resenha.core_networking

import io.ktor.client.plugins.logging.Logger

object KtorLogger : Logger {
    override fun log(message: String) {
        println("HttpClient $message")
    }
}