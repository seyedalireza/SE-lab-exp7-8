plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.google.cloud.tools.jib") version "3.1.4"
	`java`
}

group = "ir.sharif"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

ext {
	set("springCloudVersion", "2021.0.0")
}

dependencies {
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.0")
	}
}

jib {
	from {
		image = "adoptopenjdk/openjdk11:jre-11.0.10_9-ubuntu"
	}
	to {
		image = "sharif/gateway"
		tags = setOf("latest", "$version")
	}
	container {
		mainClass = "ir.sharif.gateway.GatewayApplication"
	}
}