package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDto;
import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PostUpdateRequest;
import com.example.demo.dto.PostUpdateResponse;
import com.example.demo.service.PostService;

@RestController
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 게시글(Post) 작성
	@PostMapping("/posts")
	public Long post(
		@RequestBody PostRequest request
	) {
		return postService.post(request);
	}


	// 조회
	@GetMapping("/posts")
	public PostDto post(
		@RequestParam("id") Long postId
	) {
		return postService.getPost(postId);
	}

	// 게시글 업데이트
	@PatchMapping("/posts")
	public PostUpdateResponse post(
		@RequestBody PostUpdateRequest request
	) {
		return postService.updatePost(request);
	}

}
