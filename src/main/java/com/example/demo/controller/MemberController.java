 package com.example.demo.controller;

 import com.example.demo.dto.MemberDto;
 import com.example.demo.dto.MemberUpdateRequest;
 import com.example.demo.dto.MemberUpdateResponse;
 import com.example.demo.dto.SignUpRequest;
 import lombok.RequiredArgsConstructor;
 import org.springframework.web.bind.annotation.*;

 import com.example.demo.service.MemberService;


 @RestController
 @RequiredArgsConstructor
 public class MemberController {

 	private final MemberService memberService;

     @PostMapping("/users/join")
     public String join(@RequestBody SignUpRequest request) {
         memberService.join(request);
         return "success";
     }


 	@GetMapping("/users")
 	public MemberDto getMemberDto(Long memberId) {
        return memberService.findById(memberId);
    }

 	@PatchMapping("/users")
 	public MemberUpdateResponse update(
 		@RequestBody MemberUpdateRequest request
 	) {
        return memberService.updateMember(request);
    }

 }
