plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.google.cloud.tools.jib") version "3.1.4"
	java
}

group = "ir.sharif"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation(project(":entity-module"))
	implementation(project(":security-common"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-parent:2.5.6")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")
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

jib {
	from {
		image = "adoptopenjdk/openjdk11:jre-11.0.10_9-ubuntu"
	}
	to {
		image = "sharif/admin"
		tags = setOf("latest", "$version")
	}
	container {
		mainClass = "ir.sharif.admin.AdminApplication"
	}
}