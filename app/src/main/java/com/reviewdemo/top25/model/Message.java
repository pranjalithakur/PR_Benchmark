package com.reviewdemo.top25.model;

import java.util.Date;

public class Message {
	private int id;
	private String sender;
	private String recipient;
	private String content;
	private Date sentAt;

	public Message(int id, String sender, String recipient, String content, Date sentAt) {
		this.id = id;
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
		this.sentAt = sentAt;
	}

	public int getId() {
		return id;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getContent() {
		return content;
	}

	public Date getSentAt() {
		return sentAt;
	}
}
