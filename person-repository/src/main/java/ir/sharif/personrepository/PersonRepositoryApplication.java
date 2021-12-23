package ir.sharif.personrepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("ir.sharif")
@EnableJpaRepositories(basePackages = "ir.sharif")
@EntityScan("ir.sharif.entity")
@EnableSwagger2
public class PersonRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonRepositoryApplication.class, args);
	}

}
