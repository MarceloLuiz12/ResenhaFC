import extensions.iosTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    jvm()

    iosTarget()
}
