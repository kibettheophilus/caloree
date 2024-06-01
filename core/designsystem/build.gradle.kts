plugins {
    alias(libs.plugins.caloreeMultiplaform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
        }
    }
}

android {
    namespace = "com.theophiluskibet.caloree.designsystem"
}
