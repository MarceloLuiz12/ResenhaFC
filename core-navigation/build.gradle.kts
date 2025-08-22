plugins {
    id("dev.marcelo.resenha.kmp-library")
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.navigation.compose)

            implementation(compose.material3)
            implementation(compose.components.resources)
        }
    }
}