import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"
}
group = "me.josenunez"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}
dependencies {
    val jUnitVersion = "5.5.2"
    val skrapeitVersion = "1.0.0-alpha6"

    testImplementation(
            group = "org.junit.jupiter",
            name = "junit-jupiter",
            version = jUnitVersion
    )
    implementation(
        group = "it.skrape",
        name = "skrapeit-core",
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