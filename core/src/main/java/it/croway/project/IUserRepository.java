package it.croway.project;

import java.util.Collection;
import java.util.Optional;

public interface IUserRepository {

	public Optional<User> findByName(String name);
	public Collection<User> findAll();
	public Optional<User> findById(String id);
	public User insert(User t);
	public void update(User t);
	
}
