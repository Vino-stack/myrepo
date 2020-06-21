package com.atossyntel.cms.model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cust")
public class Customer {
@Id	
private int customerId;
private String firstName;
private String lastName;
private String gender;
private String email;
private String address;
private String city;
private String state;

public Customer() {
this.customerId=new Random().nextInt(100000);
}

public Customer(String firstName, String lastName, String gender, String email, String address, String city,
		String state) {
	this.customerId=new Random().nextInt(100000);
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.email = email;
	this.address = address;
	this.city = city;
	this.state = state;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
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

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
			+ gender + ", email=" + email + ", address=" + address + ", city=" + city + ", state=" + state + "]";
}
	
}
