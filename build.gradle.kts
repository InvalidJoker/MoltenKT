import org.gradle.api.JavaVersion.VERSION_21
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.3.10"
    kotlin("plugin.serialization") version "2.3.10"
    `maven-publish`
}

repositories {
    mavenCentral()
}


kotlin {
    jvmToolchain(21)
}

java {
    sourceCompatibility = VERSION_21
    targetCompatibility = VERSION_21
}

allprojects {

    version = "1.0-PRE-17"
    group = "de.moltenKt"

    /**tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }*/



}