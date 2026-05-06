plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `maven-publish`
}

repositories {
    mavenCentral()
}

var host = "github.com/TheFruxz/MoltenKT"

dependencies {

    @Suppress("DependencyOnStdlib") implementation(kotlin("stdlib"))

    implementation(project(":MoltenKT-Core"))

    implementation("net.kyori:adventure-api:4.11.0")
    implementation("net.kyori:adventure-text-serializer-legacy:4.11.0")
    implementation("net.kyori:adventure-text-minimessage:4.11.0")
    implementation("net.kyori:adventure-text-serializer-plain:4.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation("io.ktor:ktor-client-core-jvm:2.1.1")

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

    publications.create("MoltenKT-Unfold", MavenPublication::class) {

        from(components["kotlin"])

        artifact(source)

        artifactId = "moltenkt-unfold"
        version = version.lowercase()

    }

}