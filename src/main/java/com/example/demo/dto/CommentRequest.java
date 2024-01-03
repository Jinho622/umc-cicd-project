package com.example.demo.dto;

public class CommentRequest {
    private String text;

    private Long memberId;

    private Long postId;


    public String getText() {
        return text;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getPostId() {
        return postId;
    }
}
