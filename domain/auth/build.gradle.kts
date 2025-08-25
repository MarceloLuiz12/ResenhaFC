
plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    jvm()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "resenha"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies{
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}