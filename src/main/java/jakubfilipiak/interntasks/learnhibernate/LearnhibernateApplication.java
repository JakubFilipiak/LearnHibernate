package jakubfilipiak.interntasks.learnhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties")
@SpringBootApplication
public class LearnhibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnhibernateApplication.class, args);
	}

}
