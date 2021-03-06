package org.selenium.pom.objects;

public class BillingAddress {
	
	//create POJO class
	//step1: create private variables
	private String firstName;
	private String lastName;
	private String addressLine;
	private String city;
	private String postalCode;
	private String email;
	private String country;
	private String state;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BillingAddress() {
		
	}
	//parameterized constructor
	public BillingAddress(String firstName,String lastName,String addressLine,String city,String postalCode,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine = addressLine;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
				
	}
	
	//step 2 : generate getters and setters
	//right click -> source -> generate getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	public BillingAddress setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public BillingAddress setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public BillingAddress setAddressLine(String addressLine) {
		this.addressLine = addressLine;
		return this;
	}
	public String getCity() {
		return city;
	}
	public BillingAddress setCity(String city) {
		this.city = city;
		return this;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public BillingAddress setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public BillingAddress setEmail(String email) {
		this.email = email;
		return this;
	}
	
	

}
