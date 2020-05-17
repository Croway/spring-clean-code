package it.croway.adapter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import it.croway.project.UserService;

@SpringBootApplication
public class SpringApplicationAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationAdapter.class, args);
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	void init() {
		jdbcTemplate.execute("CREATE TABLE User (username varchar, name varchar, surname varchar)");
		
		jdbcTemplate.update("INSERT INTO User VALUES ('user', 'name', 'surname')");
		jdbcTemplate.update("INSERT INTO User VALUES ('user1', 'name1', 'surname1')");
	}

	@Bean
	public UserService userService(UserRepository userRepository) {
		return new UserService(userRepository);
	}

}
