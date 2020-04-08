package fr.carboat.models;

public class Vehicle {

	String make;
	String model;
	String version;
	String category;
	String registerNumber;
	Long mileage;

	public Vehicle(String make, String model, String version, String category,
			String registerNumber, Long mileage) {
		super();
		this.make = make;
		this.model = model;
		this.version = version;
		this.category = category;
		this.registerNumber = registerNumber;
		this.mileage = mileage;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public Long getMileage() {
		return mileage;
	}

	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}

}
