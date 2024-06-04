import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.caloreeMultiplaform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.ktor)

            implementation(libs.koin.core)
        }

        commonTest.dependencies {
            implementation(libs.ktor.client.mock)
            implementation(libs.kotlin.test.junit)
            implementation(libs.kotlin.test)
            implementation(libs.coroutines.test)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.theophiluskibet.caloree.network"
}

buildkonfig {
    packageName = "com.theophiluskibet.caloree.network"

    defaultConfigs {
        val apiKey: String = gradleLocalProperties(rootDir).getProperty("API_KEY")

        require(apiKey.isNotEmpty()) {
            "Register your api key from developer and place it in local.properties as `API_KEY`"
        }

        buildConfigField(STRING, "API_KEY", apiKey)
    }
}