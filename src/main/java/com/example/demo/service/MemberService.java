package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.MemberUpdateRequest;
import com.example.demo.dto.MemberUpdateResponse;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public void join(SignUpRequest request) {
		Member member = Member.builder()
				.name(request.getName())
				.age(request.getAge())
				.gender(request.getGender())
				.build();
		memberRepository.save(member);
	}

	@Transactional
	public MemberDto findById(Long id) {
		// 과제
		Member member = memberRepository.findById(id).orElseThrow();
		return MemberDto.builder()
				.id(member.getId())
				.name(member.getName())
				.age(member.getAge())
				.gender(member.getGender())
				.build();
	}

	@Transactional
	public MemberUpdateResponse updateMember(MemberUpdateRequest request) {

		// memberRepository.findById(request.getId());
		// if Id not in 영속성 컨텍스트
		//		SQL 날린다. <- 스냅샷(처음 상태), heap(개발자가 사용하는 것) <- Member 객체를 만든다 <- SQL 정보를 받아온다.
		// else
		// 		영속성 컨텍스트로부터 조회를 한다.

		// db에서 가져옴
		Member member = memberRepository.findById(request.getId()).orElseThrow();
		// 다음부터는 영속성 컨텍스트에서 가져옴
		// Member member1 = memberRepository.findById(request.getId()).orElseThrow();
		// member에 set하면 db에도 자동으로 업데이트 시켜줌

		// 변경감지 더티체킹
		// entity의 필드값이 변하면 업데이트 query나감, 하지만 변경감지하면 영속성 컨텍스트(스냅샷)와 필드값 비교해서 업데이트 시킴
		// 때문에 memberRepository.save안해도됨 <- save는 추가할 때만
		member.setName(request.getName());
		member.setAge(request.getAge());
		member.setGender(request.getGender());

		return MemberUpdateResponse.builder()
				.name(member.getName())
				.age(member.getAge())
				.gender(member.getGender())
				.build();
	}
}
