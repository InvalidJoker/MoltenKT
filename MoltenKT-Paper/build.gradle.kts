import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.JavaVersion.VERSION_17
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.gradleup.shadow") version "9.4.1"
    `maven-publish`
}

var host = "github.com/TheFruxz/MoltenKT"

repositories {

    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/") // PaperMC
    maven("https://libraries.minecraft.net") // Minecraft (Brigadier)
}

dependencies {

    // Internal

    implementation(project(":MoltenKT-Core"))
    implementation(project(":MoltenKT-Unfold"))

    shadow(project(":MoltenKT-Core")) {
        isTransitive = false
    }
    shadow(project(":MoltenKT-Unfold")) {
        isTransitive = false
    }

    // Kotlin

    testImplementation(kotlin("test"))
    @Suppress("DependencyOnStdlib") shadow(kotlin("stdlib"))
    shadow(kotlin("reflect"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // External

    implementation("org.slf4j:slf4j-api:2.0.2")
    //implementation("com.mojang:brigadier:1.0.18")

    // > Ktor
    implementation("io.ktor:ktor-client-cio:2.1.1")
    implementation("io.ktor:ktor-client-core-jvm:2.1.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.1")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.1")

    implementation("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT") // PaperMC
    //compileOnly("me.clip:placeholderapi:2.11.2") // PlaceholderAPI

    // Shadow

    shadow("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    shadow("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    shadow("org.slf4j:slf4j-api:2.0.1")
    shadow("net.kyori:adventure-text-serializer-plain:4.11.0")

    shadow("org.jetbrains.exposed:exposed-core:0.39.2")
    shadow("org.jetbrains.exposed:exposed-dao:0.39.2")
    shadow("org.jetbrains.exposed:exposed-jdbc:0.39.2")

    // > Ktor
    shadow("io.ktor:ktor-client-cio:2.1.1")
    shadow("io.ktor:ktor-client-core-jvm:2.1.1")
    shadow("io.ktor:ktor-serialization-kotlinx-json:2.1.1")
    shadow("io.ktor:ktor-client-content-negotiation:2.1.1")

    shadow("net.kyori:adventure-api:4.11.0")
    shadow("net.kyori:adventure-text-serializer-legacy:4.11.0")
    shadow("net.kyori:adventure-text-minimessage:4.11.0")

}

val source by tasks.register<Jar>("sourceJar") {
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.$host")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications.create("MoltenKT-Paper", MavenPublication::class) {

        from(components["kotlin"])

        artifact(source)

        artifactId = "moltenkt-paper"
        version = version.lowercase()

    }
}

tasks {

    build {
        dependsOn(shadowJar)
    }

    named<ShadowJar>("shadowJar") {
        archiveClassifier.set("Runnable")
        configurations = listOf(project.configurations.shadow.get())
    }

    test {
        useJUnitPlatform()
    }

    processResources {
        expand("version" to project.version, "name" to project.name, "website" to "https://$host")
    }

}

