package com.reviewdemo.top25.model;

import java.util.Date;

public class Attachment {
	private int id;
	private String owner;
	private String fileName;
	private String path;
	private Date uploadedAt;

	public Attachment(int id, String owner, String fileName, String path, Date uploadedAt) {
		this.id = id;
		this.owner = owner;
		this.fileName = fileName;
		this.path = path;
		this.uploadedAt = uploadedAt;
	}

	public int getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public String getFileName() {
		return fileName;
	}

	public String getPath() {
		return path;
	}

	public Date getUploadedAt() {
		return uploadedAt;
	}
}
