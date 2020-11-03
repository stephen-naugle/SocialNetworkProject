package com.web.model;

import java.time.LocalDate;

/**
 * @author Andrew Pearse
 * User model
 */
public class User {

	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private String occupation;
	private String bio;
	private String address;
	private LocalDate dob;

	
	/**
	 * Creates a new user
	 * @param username unique identifier for user
	 * @param password key to log in to user account
	 * @param email email address for user
	 * @param firstname first name of user
	 * @param lastname last name of user
	 * @param phoneNumber phone number for user
	 * @param occupation job of user
	 * @param bio short description of the user
	 * @param address current address of the user
	 * @param dob date of birth of the user
	 */
	public User(String username, String password, String email, String firstname, String lastname, String phoneNumber,
			String occupation, String bio, String address, LocalDate dob) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
		this.bio = bio;
		this.address = address;
		this.dob = dob;
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", phoneNumber=" + phoneNumber + ", occupation=" + occupation + ", bio="
				+ bio + ", address=" + address + ", dob=" + dob + "]";
	}

}