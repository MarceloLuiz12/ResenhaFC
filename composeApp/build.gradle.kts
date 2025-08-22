
plugins {
    id("dev.marcelo.resenha.application")
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(compose.preview)
            implementation(libs.lottie)
        }
        commonMain.dependencies {
            implementation(projects.featureAuth)
            implementation(projects.coreUi)

            implementation(libs.koin.compose.viewmodel.navigation)

            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)

            implementation(libs.koin.core)
        }
    }
}