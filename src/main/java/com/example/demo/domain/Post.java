package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private String title;
	// private boolean active;

//	public void delete(){
//		this.active = false;
//	}
	// -> 생성자에 active 포함시키기


	// 매핑
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;

	public Post(String text, String title, Member member) {
		this.text = text;
		this.title = title;
		this.member = member;
	}

	protected Post() {
	}

	// comment 양방향 매핑 (comment삭제 시 post함께 삭제되는 것 방지)
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> reviewList = new ArrayList<>();
}
