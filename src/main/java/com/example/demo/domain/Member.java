package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// Member의 구성요소 - id, 이름, 닉네임, 나이, 성별
@Entity
@Getter
@Setter
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;

	private String name;

	private Integer age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(mappedBy = "member")
	private List<Post> posts = new ArrayList<>();

	// comment 양방향 매핑 (comment삭제 시 member함께 삭제되는 것 방지)
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	@Builder
	// Id는 db에서 결정
	public Member(String name, Integer age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	/**
	 * 이건 지우지말고 냅두세요
	 */
	protected Member() {
	}

}
