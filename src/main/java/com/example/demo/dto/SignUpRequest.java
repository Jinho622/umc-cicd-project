package com.example.demo.dto;

import com.example.demo.domain.Gender;
import lombok.Getter;

@Getter
public class SignUpRequest {

    private String name;
    private Integer age;
    private Gender gender;
}
