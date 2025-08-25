rootProject.name = "ResenhaFC"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("org.jetbrains.kotlinx.kover.aggregation") version "0.9.1"
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

include(":composeApp")
include(":core-ui")
include(":core-networking")
include(":feature-auth")
include(":domain")
include(":domain:auth")
include(":data")
include(":data:auth")

kover {
    enableCoverage()

    reports {
        includedProjects.addAll(
            ":composeApp"
        )
        excludedClasses.add("*.BuildConfig")
        excludedClasses.add("*.ComposableSingletons")
        excludedClasses.add("*ScreenKt*")
        excludedClasses.add("*.di.*")
        excludesAnnotatedBy.add("Generated")

        verify {
            rule {
                name = "Minimum Coverage"
                bound {
                    minValue = 80
                }
            }
        }
    }
}
