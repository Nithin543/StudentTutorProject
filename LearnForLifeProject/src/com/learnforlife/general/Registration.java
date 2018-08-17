package com.learnforlife.general;

import java.util.ArrayList;
import java.util.List;

public class Registration {
	private String username;
	private String password;
	private String email;
	private String role;
	private String gender;
	private List<String> roleOptions;

	public Registration() {
		roleOptions = new ArrayList<>();
		roleOptions.add("SELECT A ROLE");
		roleOptions.add("STUDENT");
		roleOptions.add("TUTOR");
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getRoleOptions() {
		return roleOptions;
	}

	public void setRoleOptions(List<String> roleOptions) {
		this.roleOptions = roleOptions;
	}

}
