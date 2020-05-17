package it.croway.project;

import java.util.Collection;
import java.util.Optional;

public class UserService {

	IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findById(username);
	}
	
	public Optional<User> findByName(String name) {
		return userRepository.findByName(name);
	}

}
