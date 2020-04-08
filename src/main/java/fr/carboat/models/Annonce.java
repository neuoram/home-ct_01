package fr.carboat.models;

import java.util.Date;

public class Annonce {

	Contacts contacts;
	Date creationDate;
	int price;
	String publicationOptions[];
	String reference;
	Vehicle vehicle;

	public Annonce(Contacts contacts, Date creationDate, int price,
			String[] publicationOptions, String reference, Vehicle vehicle) {
		super();
		this.contacts = contacts;
		this.creationDate = creationDate;
		this.price = price;
		this.publicationOptions = publicationOptions;
		this.reference = reference;
		this.vehicle = vehicle;
	}

	public Annonce() {
		super();
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String[] getPublicationOptions() {
		return publicationOptions;
	}

	public void setPublicationOptions(String[] publicationOptions) {
		this.publicationOptions = publicationOptions;
	}

}
