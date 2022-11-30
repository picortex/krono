plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("org.jetbrains.dokka")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx.serialization.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.expectCoroutines)
                implementation(kotlinx.serialization.json)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.root.get(),
    description = "An multiplatform interoperable datetime library"
)