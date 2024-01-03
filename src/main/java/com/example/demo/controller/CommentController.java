package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글(Comment) 작성
    @PostMapping("/comments")
    public Long comment(
            @RequestBody CommentRequest request
    ) {
        return commentService.comment(request);
    }

    // 댓글 업데이트
    @PatchMapping("/comments")
    public CommentUpdateResponse comment(
            @RequestBody CommentUpdateRequest request
    ) {
        return commentService.updateComment(request);
    }

    // 댓글 삭제
    @DeleteMapping("/comments")
    public Long comment(
            @RequestBody CommentDeleteRequest request
    ) {
        return commentService.delete(request);
    }
}
