package models;

public class Customers {
	private String id_customer;
	private String login;
	private String firstName;
	private String lastName;
	private String password;
	
	public Customers(String id_customer, String login, String firstName, String lastName, String password) {
		this.id_customer = id_customer;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getId_customer() {
		return id_customer;
	}

	public String getLogin() {
		return login;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}
	
	
}
