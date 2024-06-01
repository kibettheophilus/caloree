plugins {
    alias(libs.plugins.caloreeMultiplaform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.core.designsystem)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
        }
    }
}
android {
    namespace = "com.theophiluskibet.caloree.calorees"
}
