plugins {
    id("dev.marcelo.resenha.kmp-library")
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
        }

        commonMain.dependencies {

            implementation(projects.coreNetworking)

            implementation(compose.components.resources)
            implementation(compose.material3)
            implementation(compose.ui)

            implementation(libs.koin.compose.viewmodel.navigation)

            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.client.content.negotiation)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
        }
    }
}