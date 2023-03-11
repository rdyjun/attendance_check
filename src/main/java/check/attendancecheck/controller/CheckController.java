package check.attendancecheck.controller;

import check.attendancecheck.entity.Member;
import check.attendancecheck.entity.MemberDTO;
import check.attendancecheck.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;
    @PostMapping("/checksuccess")
    public void check(@RequestBody Member member){
        checkService.save(member);
    }
}
