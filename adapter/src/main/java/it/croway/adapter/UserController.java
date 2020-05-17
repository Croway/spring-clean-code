package it.croway.adapter;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.croway.project.User;
import it.croway.project.UserService;

@RestController
public class UserController {

	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "users")
	public ResponseEntity<Collection<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping(value = "users", params = "name")
	public ResponseEntity<User> findByName(@RequestParam String name) {
		return ResponseEntity.of(userService.findByName(name));
	}
	
	@GetMapping(value = "users/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable String username) {
		return ResponseEntity.of(userService.findByUsername(username));
	}
	
}
