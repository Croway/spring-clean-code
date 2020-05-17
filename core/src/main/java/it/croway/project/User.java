package it.croway.project;

import java.util.List;

public class User {

	private String username;
	private String name;
	private String surname;
	private List<Phone> phones;
	
	public User() {
		super();
	}

	public User(String username, String name, String surname) {
		this.username = username;
		this.name = name;
		this.surname = surname;
//		this.phones = phones;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
