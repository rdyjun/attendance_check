package check.attendancecheck.service;

import check.attendancecheck.entity.Atdc;
import check.attendancecheck.entity.Member;
import check.attendancecheck.repository.AtdcRepository;
import check.attendancecheck.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckService {
    private final AtdcRepository atdcRepository;
    private final MemberRepository memberRepository;
    public void save(Member member){
        validateMember(member);
        atdcRepository.save(new Atdc(member, validateType(member)));
    }

    public void validateMember (Member member) {
        memberRepository.findByMember(member)
                .ifPresent(m -> {
                            throw new IllegalStateException("존재하지 않는 회원입니다.");
                        }
                );
    }
    public String validateType(Member member){
        int on = atdcRepository.findByMember(member.getStdId());
        if (on == 0) {
            return "출근";
        } else {
            if (on % 2 == 0)
                return "출근";
            else
                return "퇴근";
        }
    }
}
