package com.example.demo.dto;
import com.example.demo.domain.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberUpdateResponse {

    private String name;
    private Integer age;
    private Gender gender;

    @Builder
    public MemberUpdateResponse(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
