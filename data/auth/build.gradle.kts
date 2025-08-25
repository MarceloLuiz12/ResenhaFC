plugins {
    id("dev.marcelo.resenha.kmp-library")
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain.auth)
            implementation(projects.coreNetworking)

            implementation(libs.koin.core)

            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.client.content.negotiation)
        }
    }
}