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

        commonTest.dependencies {
            implementation(libs.kotlin.test.junit)
            implementation(libs.kotlin.test)
            implementation(libs.coroutines.test)
        }
    }
}

android {
    namespace = "com.theophiluskibet.caloree.data"
}
