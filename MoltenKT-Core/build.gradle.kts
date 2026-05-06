import org.gradle.api.JavaVersion.VERSION_21
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `maven-publish`
}

var host = "github.com/TheFruxz/MoltenKT"

repositories {
    mavenCentral()
}

dependencies {

    // Kotlin

    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.slf4j:slf4j-api:2.0.2")

    implementation("org.jetbrains.exposed:exposed-core:0.39.2")
    implementation("org.jetbrains.exposed:exposed-dao:0.39.2")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.39.2")

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

    publications.create("MoltenKT-Core", MavenPublication::class) {

        from(components["kotlin"])

        artifact(source)

        artifactId = "moltenkt-core"
        version = version.lowercase()

    }

}

tasks {

    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.addAll(
                listOf(
                    "-opt-in=kotlin.time.ExperimentalTime",
                    "-opt-in=kotlin.ExperimentalStdlibApi",
                    "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
                    "-opt-in=kotlin.io.path.ExperimentalPathApi",
                    "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
                )
            )
        }
    }

    /*withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "21"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.time.ExperimentalTime"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.ExperimentalStdlibApi"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.io.path.ExperimentalPathApi"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
    }

*/
}