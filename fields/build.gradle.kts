plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

description = "A kotlin multiplatform library for headless input date and time fields"

kotlin {
    jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasm { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kronoKotlinx)
                api(libs.symphony.input.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.symphony.input.text)
                implementation(libs.symphony.input.choice)
                implementation(libs.kommander.coroutines)
                implementation(libs.koncurrent.later.coroutines)
                implementation(libs.cinematic.live.test)
                implementation(libs.koncurrent.executors.mock)
            }
        }
    }
}