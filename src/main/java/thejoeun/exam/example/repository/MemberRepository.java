package thejoeun.exam.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thejoeun.exam.example.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
