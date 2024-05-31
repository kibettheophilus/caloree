plugins {
    alias(libs.plugins.caloreeMultiplaform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.room.runtime)
            implementation(libs.koin.core)
            implementation(libs.sqlite.bundled)
        }

        sourceSets.commonMain {
            kotlin.srcDir("build/generated/ksp/metadata")
        }
    }
}

android {
    namespace = "com.theophiluskibet.caloree.local"
}

dependencies {
//    add("kspAndroid", libs.androidx.room.compiler)
//    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
//    add("kspIosX64", libs.androidx.room.compiler)
//    add("kspIosArm64", libs.androidx.room.compiler)
    add("kspCommonMainMetadata", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}
