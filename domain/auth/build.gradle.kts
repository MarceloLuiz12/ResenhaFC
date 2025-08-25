plugins {
    id("dev.marcelo.resenha.domain")
}

kotlin {
    sourceSets {
        commonMain.dependencies{
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}