package com.example.demo.dto;

import com.example.demo.domain.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberUpdateRequest {

    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
}
