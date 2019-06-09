rootProject.name = "gradle-multi-module-template"

include("some-service")

val kotlinVersion: String by settings
val springBootPluginVersion: String by settings
val springDependencyManagementPluginVersion: String by settings
val shadowPluginVersion: String by settings

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootPluginVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementPluginVersion)
            }
        }
    }
}