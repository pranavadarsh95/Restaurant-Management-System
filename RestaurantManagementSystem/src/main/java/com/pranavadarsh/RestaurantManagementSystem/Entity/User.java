package com.pranavadarsh.RestaurantManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(min = 10, max = 10,message="Please provide correct 10-digit Contact number")
	@Column(name = "CONTACT_NUMBER", unique = true, nullable = false)
	private String contactNumber;
	
	@Email(message="Please provide Valid Email Address")
	@Column(name = "EMAIL_ID", unique = true, nullable = false)
	private String emailId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Size(min = 4, max = 100,message="Please provide atleast 4-digit password")
	@Column(name="password")
	private String password;

	
	public User() {
		
	}


	public User(String contactNumber, String emailId, String firstName, String lastName, String password) {
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
