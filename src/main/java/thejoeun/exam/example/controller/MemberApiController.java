package thejoeun.exam.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import thejoeun.exam.example.model.Member;
import thejoeun.exam.example.model.dto.MemberRequestDto;
import thejoeun.exam.example.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    @Autowired
    final MemberService memberService;

    @PostMapping(path = "/api/signup")
    public ResponseEntity<Member> signup(@RequestBody MemberRequestDto request){
        Member member = memberService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(member);
    }

    @PostMapping(path = "/api/login")
    public ResponseEntity<Member> login(@RequestBody MemberRequestDto request){
        Member member = memberService.findByEmail(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(member);
    }

}
