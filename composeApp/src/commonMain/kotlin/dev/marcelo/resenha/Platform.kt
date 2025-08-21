package dev.marcelo.resenha

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform