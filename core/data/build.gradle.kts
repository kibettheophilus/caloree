import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.caloreeMultiplaform)
}

android {
    namespace = "com.theophiluskibet.caloree.data"

    ktlint {
        reporters {
            reporter(ReporterType.JSON)
        }
        filter {
            exclude("**/generated/**")
//            include("**/kotlin/**")
        }
    }
}
