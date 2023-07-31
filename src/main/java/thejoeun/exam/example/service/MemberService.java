package thejoeun.exam.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thejoeun.exam.example.model.Member;
import thejoeun.exam.example.model.dto.MemberRequestDto;
import thejoeun.exam.example.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    final MemberRepository memberRepository;

    public Member save(MemberRequestDto request) {
        return memberRepository.save(request.toEntity());
    }

    public Member findByEmail(MemberRequestDto request) {
        if(request.getPassword().equals(memberRepository.findByEmail(request.getEmail()).getPassword())) {
            return memberRepository.findByEmail(request.getEmail());
        } else {
            throw new RuntimeException();
        }
    }
}
