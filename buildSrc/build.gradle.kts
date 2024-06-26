plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.9.23"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    implementation("io.github.goooler.shadow:shadow-gradle-plugin:8.1.7")
}
