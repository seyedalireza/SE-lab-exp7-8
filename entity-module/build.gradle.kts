plugins {
    `java-library`
}

group = "ir.sharif"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.persistence:javax.persistence-api:2.2")
    testImplementation("junit:junit:4.12")
}

tasks {
    test {
        useJUnitPlatform()
    }
}