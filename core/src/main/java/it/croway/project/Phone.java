package it.croway.project;

public class Phone {

	private User user;
	private String number;
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
