package it.croway.adapter;

import java.util.Collection;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.croway.project.IUserRepository;
import it.croway.project.User;

@Repository
public class UserRepository implements IUserRepository {

	private static final BeanPropertyRowMapper<User> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);

	private final JdbcTemplate jdbcTemplate;

	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Collection<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM User", USER_ROW_MAPPER);
	}

	@Override
	public Optional<User> findById(String id) {
		User result = null;
		try {
			result = jdbcTemplate.queryForObject("SELECT * FROM User WHERE username = ?", USER_ROW_MAPPER, id);
		} catch (EmptyResultDataAccessException ex) {
			result = null;
		}
		return Optional.ofNullable(result);
	}

	@Override
	public Optional<User> findByName(String name) {
		User result = null;
		try {
			result = jdbcTemplate.queryForObject("SELECT * FROM User WHERE name = ?", USER_ROW_MAPPER, name);
		} catch (EmptyResultDataAccessException ex) {
			result = null;
		}
		return Optional.ofNullable(result);
	}

	@Override
	public User save(User t) {
		jdbcTemplate.update("INSERT INTO User VALUES (?, ?, ?)", t.getUsername(), t.getName(), t.getSurname());
		return t;
	}

	@Override
	public void updateName(String user, String name) {
		// TODO Auto-generated method stub

	}

}
