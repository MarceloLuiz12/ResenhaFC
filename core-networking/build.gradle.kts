
import com.codingfeline.buildkonfig.compiler.FieldSpec

plugins {
    id("dev.marcelo.resenha.kmp-library")
    alias(libs.plugins.buildkonfig.plugin)
}

buildkonfig {
    packageName = "core.networking"

    defaultConfigs {
        buildConfigField(FieldSpec.Type.STRING, "HOST", "Hello World")
    }

}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.auth)
        }

        androidMain.dependencies {
            implementation(libs.okhttp)
            implementation(libs.interceptor)
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}