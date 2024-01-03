package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Member;
import com.example.demo.domain.Post;
import com.example.demo.dto.*;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final PostRepository postRepository;

    //new
    private final MemberRepository memberRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(PostRepository postRepository, MemberRepository memberRepository, CommentRepository commentRepository) {

        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }

    // Comment 작성
    @Transactional
    public Long comment(CommentRequest request) {
        Member member = memberRepository.findById((request.getMemberId())).get();
        Post post = postRepository.findById((request.getPostId())).get();
        // LAZY LOADING <- 영속성, 필요할 때 가지고 오는 것 <-> EAGER LOADING
        // ONE TO MANY는 기본이 LAZY, MANY TO ONE은 기본이 EAGER(따라서 LAZY로 쓸 때 따로 명시해주어야 한다.)
        // 네트워크 비용 때문에 쿼리 한번에 날리는게 낫다. 때문에 LAZY에서 따로 쿼리문을 작성해주는 것이다.
        List<Comment> comments = member.getComments();
        Comment comment = new Comment(request.getText(), member, post);
        Comment savedComment = commentRepository.save(comment);
        return savedComment.getId();
    }

    @Transactional
    public CommentUpdateResponse updateComment(CommentUpdateRequest request) {
        // 조회하는 것은 위와 같음
        Optional<Comment> optionalComment = commentRepository.findById(request.getId());
        Comment comment = optionalComment.get();

        // SQL
        // SQL Mapper
        // JPA
        // 1. JPQL
        // 2. QueryDSL
        // 3. Native Query <- SQL

        // 조회후 엔티티 내부의 필드 변경
        comment.setText(request.getText());

        return new CommentUpdateResponse(
                comment.getText()
        );
    }

    @Transactional
    public Long delete(CommentDeleteRequest request){
        // 조회하는 것은 위와 같음
        commentRepository.deleteById(request.getId());
        //Comment comment = optionalComment.get();
        // 조회후 엔티티 내부의 필드 변경
        return request.getId();
    }

}
