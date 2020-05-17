package it.croway.project;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	private String number;
	@ManyToOne
	private User user;
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	public Phone() {
		super();
	}

	public Phone(String number, PhoneType type, User user) {
		super();
		this.number = number;
		this.type = type;
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
