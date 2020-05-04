rootProject.name = "gradle-multi-module-template"

include("some-service")

val kotlinVersion: String by settings
val springBootPluginVersion: String by settings
val springDependencyManagementPluginVersion: String by settings
val shadowPluginVersion: String by settings

pluginManagement {
    plugins {
        fun String.getVersion() = extra["$this.version"].toString()
        fun PluginDependenciesSpec.resolve(id: String, versionKey: String = id) = id(id) version versionKey.getVersion()

        resolve("org.jetbrains.kotlin.jvm")
        resolve("org.jetbrains.kotlin.plugin.spring", "org.jetbrains.kotlin.jvm")
        resolve("org.springframework.boot")
    }
}