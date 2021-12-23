plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	java
}

group = "ir.sharif"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation(project(":entity-module"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}


tasks {
	test {
		useJUnitPlatform()
	}
}
repositories {
	mavenCentral()
}