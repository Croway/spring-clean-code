package it.croway.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import it.croway.project.User;
import it.croway.project.UserService;

@SpringBootApplication
@EntityScan(basePackages = "it.croway")
public class SpringApplicationAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationAdapter.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@EventListener(ContextRefreshedEvent.class)
	public void onApplicationEvent(ContextRefreshedEvent event) {
		event.getApplicationContext().getBean(SpringApplicationAdapter.class).initialize();
	}

	@Transactional
	public void initialize() {
		userRepository.save(new User("username1", "name1", "surname1"));
		userRepository.save(new User("username2", "name2", "surname2"));

		userRepository.updateName("username1", "pippo");
	}

	@Bean
	public UserService userService(UserRepository userRepository) {
		return new UserService(userRepository);
	}

}
