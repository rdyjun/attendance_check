package check.attendancecheck.service;

import check.attendancecheck.entity.Atdc;
import check.attendancecheck.entity.Member;
import check.attendancecheck.repository.AtdcRepository;
import check.attendancecheck.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CheckService {
    private final AtdcRepository atdcRepository;
    private final MemberRepository memberRepository;
    public void save(Member member){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String sdfDate = sdf.format(new Date());
        validateMember(member);
        atdcRepository.save(new Atdc(member, validateType(member, sdfDate.substring(0, 8)), sdfDate));
    }

    public void validateMember (Member member) {
        if (memberRepository.findByMember(member).isEmpty())
            throw new IllegalStateException("존재하지 않는 회원입니다.");
    }
    public String validateType(Member member, String date){
        int on = atdcRepository.findByMember(member.getStdId(), date);
        System.out.println(on);
        if (on % 2 == 0)
            return "출근";
        else
            return "퇴근";
    }
}
