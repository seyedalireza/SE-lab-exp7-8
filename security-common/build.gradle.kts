plugins {
    id("org.springframework.boot") version "2.6.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    `java-library`
}

group = "ir.sharif"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.postgresql:postgresql")

    implementation(project(":entity-module"))
    implementation("javax.persistence:javax.persistence-api:2.2")
    api("org.springframework.boot:spring-boot-starter-security")
    api("io.jsonwebtoken:jjwt:0.9.1")

    testImplementation("junit:junit:4.12")
}

tasks {
    test {
        useJUnitPlatform()
    }
}