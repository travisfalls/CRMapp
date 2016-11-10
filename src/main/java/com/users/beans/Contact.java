package com.users.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String phoneNumber;
	private boolean active;
	
	private long userId;
	
	private String twitterHandle;
	private String facebookUrl;

	

	public Contact(String firstName, String lastName, String email, String phoneNumber, boolean active, long userId, String twitterHandle, String facebookUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.userId = userId;
		this.twitterHandle = twitterHandle;
		this.facebookUrl = facebookUrl;
	}

	public Contact(){
		
	}
	
	public Contact(long userId){
		this.userId = userId;
		this.active = true;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public String getTwitterHandle() {
		return twitterHandle;
	}
	
	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}
	
	public String getFacebookUrl() {
		return facebookUrl;
	}
	
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}


	@Override
	public String toString() { //Concatenating labels and information
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", active=" + active + "twitterHandle=" + twitterHandle + "facebookUrl=" + facebookUrl + "]";
	}

}
