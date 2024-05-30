import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

/**
 * Used to configure Caloree multiplatform libraries
 */
class MultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.library")

                extensions.configure<KotlinMultiplatformExtension> {
                    @OptIn(ExperimentalKotlinGradlePluginApi::class)
                    androidTarget {
                        compilerOptions {
                            jvmTarget.set(JvmTarget.JVM_11)
                        }
                    }
                    listOf(
                        iosX64(),
                        iosArm64(),
                        iosSimulatorArm64()
                    )
                }

                extensions.configure<LibraryExtension> {
                    compileSdk = 34
                }
            }
        }
    }
}