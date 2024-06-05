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

        commonTest.dependencies {
            implementation(libs.kotlin.test.junit)
            implementation(libs.kotlin.test)
            implementation(libs.junit)
            implementation(libs.coroutines.test)
        }

        androidMain.dependencies {
            implementation(libs.compose.ui.test.junit4)
        }
    }
}
android {
    namespace = "com.theophiluskibet.caloree.details"
}
