plugins {
    alias(libs.plugins.caloreeMultiplaform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.ktor)

            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.theophiluskibet.caloree.network"
}
