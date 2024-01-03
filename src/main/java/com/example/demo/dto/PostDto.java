package com.example.demo.dto;

public class PostDto {

	private Long id;
	private String title;
	private String text;

	public PostDto(Long id, String title, String text) {
		this.id = id;
		this.title = title;
		this.text = text;
	}
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
}
