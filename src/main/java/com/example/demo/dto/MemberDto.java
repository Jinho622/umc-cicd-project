package com.example.demo.dto;

import com.example.demo.domain.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberDto {

    private Long id;
    private String name;
    private Integer age;
    private Gender gender;

    @Builder
    public MemberDto(Long id, String name, Integer age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
