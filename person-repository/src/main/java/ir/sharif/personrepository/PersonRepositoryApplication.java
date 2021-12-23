package ir.sharif.personrepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("ir.sharif")
@EnableJpaRepositories
public class PersonRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonRepositoryApplication.class, args);
	}

}
