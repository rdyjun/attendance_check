package check.attendancecheck.repository;

import check.attendancecheck.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    @Query(value = "SELECT m FROM Member m WHERE m = :member")
    Optional<Member> findByMember(@Param("member") Member member);
}
