package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Post;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PostUpdateRequest;
import com.example.demo.dto.PostUpdateResponse;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	//new
	private final MemberRepository memberRepository;

	@Autowired
	public PostService(PostRepository postRepository, MemberRepository memberRepository) {

		this.postRepository = postRepository;
		this.memberRepository = memberRepository;
	}

//new
	// Member도 Post가지고 있어야함 -> DB에서 조회해서 가져오는 방법 or JPA에서 member에 list로 저장해준다.
	@Transactional
	public Long post(PostRequest request) {
		Member member = memberRepository.findById((request.getMemberId())).get();
		// LAZY LOADING <- 영속성, 필요할 때 가지고 오는 것 <-> EAGER LOADING
		// ONE TO MANY는 기본이 LAZY, MANY TO ONE은 기본이 EAGER(따라서 LAZY로 쓸 때 따로 명시해주어야 한다.)
		// 네트워크 비용 때문에 쿼리 한번에 날리는게 낫다. 때문에 LAZY에서 따로 쿼리문을 작성해주는 것이다.
		List<Post> posts = member.getPosts();
		Post post = new Post(request.getTitle(), request.getText(), member);
		Post savedPost = postRepository.save(post);
		return savedPost.getId();
	}

	@Transactional
	public PostDto getPost(Long postId) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		Post post = optionalPost.get();

		PostDto dto = new PostDto(post.getId(), post.getTitle(), post.getText());

		return dto;
	}


	@Transactional
	public PostUpdateResponse updatePost(PostUpdateRequest request) {
		// 조회하는 것은 위와 같음
		Optional<Post> optionalPost = postRepository.findById(request.getId());
		Post post = optionalPost.get();

		// 조회후 엔티티 내부의 필드 변경
		post.setTitle(request.getTitle());
		post.setText(request.getText());

		return new PostUpdateResponse(
			post.getText(),
			post.getTitle()
		);
	}



}
