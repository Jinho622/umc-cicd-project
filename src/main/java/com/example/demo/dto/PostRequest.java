package com.example.demo.dto;

public class PostRequest {
	private String title;
	private String text;

	// new
	private Long memberId;
	public Long getMemberId() {
		return memberId;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
}
