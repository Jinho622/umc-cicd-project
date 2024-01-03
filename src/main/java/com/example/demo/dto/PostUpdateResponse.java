package com.example.demo.dto;

public class PostUpdateResponse {
	private String text;
	private String title;

	public PostUpdateResponse(String text, String title) {
		this.text = text;
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}
}
