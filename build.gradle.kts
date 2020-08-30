import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"
}
group = "me.josenunez"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    val jUnitVersion = "5.5.2"
    val skrapeitVersion = "55884ef3"

    testImplementation(
            group = "org.junit.jupiter",
            name = "junit-jupiter",
            version = jUnitVersion
    )
    implementation(
            group = "com.github.skrapeit",
            name = "skrape.it",
            version = skrapeitVersion
    )
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}