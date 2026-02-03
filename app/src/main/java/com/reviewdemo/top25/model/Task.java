package com.reviewdemo.top25.model;

import java.util.Date;

public class Task {
	private int id;
	private String owner;
	private String title;
	private String details;
	private Date createdAt;

	public Task(int id, String owner, String title, String details, Date createdAt) {
		this.id = id;
		this.owner = owner;
		this.title = title;
		this.details = details;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public String getTitle() {
		return title;
	}

	public String getDetails() {
		return details;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
