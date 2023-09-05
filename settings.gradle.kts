pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "kommander", "symphony", "kollections", "koncurrent", "cinematic", "kase"
).forEach { includeBuild("../$it") }

rootProject.name = "krono"

includeSubs("krono", ".", "api", "kotlinx", "fields")
