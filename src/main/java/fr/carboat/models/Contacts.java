package fr.carboat.models;

public class Contacts {

	String firstName;
	String lastName;
	String email;
	Phone1 phone1;

	public Contacts(String firstName, String lastName, String email,
			Phone1 phone1) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone1 = phone1;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone1 getPhone1() {
		return phone1;
	}

	public void setPhone1(Phone1 phone1) {
		this.phone1 = phone1;
	}

}
