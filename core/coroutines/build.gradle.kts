plugins {
    id("ru.starfactory.convention.preset.core")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                api(libs.kotlin.coroutines.core)
            }
        }
    }
}
