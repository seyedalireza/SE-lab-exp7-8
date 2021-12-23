plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
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