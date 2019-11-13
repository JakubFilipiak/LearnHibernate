package jakubfilipiak.interntasks.learnhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties")
@SpringBootApplication
public class LearnhibernateApplication {

	// TODO: task 2.1 and 2.3 (@ManyToMany and @JoinTable(joinColumns = {@JoinColumn(...), ...}

	public static void main(String[] args) {
		SpringApplication.run(LearnhibernateApplication.class, args);
	}

}
