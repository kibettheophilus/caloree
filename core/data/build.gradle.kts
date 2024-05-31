plugins {
    alias(libs.plugins.caloreeMultiplaform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.network)
            implementation(projects.core.local)

            implementation(libs.koin.core)
            implementation(libs.coroutines.core)
        }
    }
}

android {
    namespace = "com.theophiluskibet.caloree.data"
}
