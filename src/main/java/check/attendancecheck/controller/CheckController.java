package check.attendancecheck.controller;

import check.attendancecheck.entity.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
    @PostMapping("/checksuccess")
    public Member check(@RequestBody Member member){
        System.out.println("1");
        return member;
    }

}
