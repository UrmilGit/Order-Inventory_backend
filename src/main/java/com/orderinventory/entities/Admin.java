package com.orderinventory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "admin", uniqueConstraints = { @UniqueConstraint(columnNames = "userName"),
@UniqueConstraint(columnNames = "emailAddress") })
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
	private int userID;

	@NotNull(message = "Username cannot be null")
	@Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
	@Column(name = "userName")
	private String userName;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email format")
	@Column(name = "emailAddress")
	private String emailAddress;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Column(name = "password")
	private String password;

	public Admin() {
		super();
	}

	public Admin(int userID,
		@NotNull(message = "Username cannot be null") @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters") String userName,
		@NotNull(message = "Email cannot be null") @Email(message = "Invalid email format") String emailAddress,
		@NotNull(message = "Password cannot be null") @Size(min = 8, message = "Password must be at least 8 characters") String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}