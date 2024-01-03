package com.example.demo.dto;

public class CommentUpdateResponse {

    private String text;

    public CommentUpdateResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}