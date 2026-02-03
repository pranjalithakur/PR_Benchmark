package com.reviewdemo.top25.model;

public class User {
	private String username;
	private String displayName;
	private String role;

	public User(String username, String displayName, String role) {
		this.username = username;
		this.displayName = displayName;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getRole() {
		return role;
	}
}
