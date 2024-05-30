plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        /**
         * Used to create a plugin
         * @param id - plugin id to be used when accessing it
         * @param className - implementation class of the plugin
         */
        fun createPlugin(id: String, className: String) {
            plugins.register(id) {
                this.id = id
                implementationClass = className
            }
        }

        /**
         * Creates multiplatform plugin
         * @sample
         * ```
         * plugins{
         *  id("caloree.multiplaform")
         * }
         * ```
         */
        createPlugin("caloree.multiplaform", "MultiplatformConventionPlugin")
    }
}

