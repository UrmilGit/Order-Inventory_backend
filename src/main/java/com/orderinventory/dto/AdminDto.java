package com.orderinventory.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminDto {
	private int userid;

	@NotNull(message = "Username cannot be null")
	@Size(min = 5, max = 20, message = "Username must be between 3 and 20 characters")
	private String username;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email format")
	private String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password;

	public AdminDto() {
	}

	public AdminDto(int userid, String username, String email, String password, String profile_picture) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
