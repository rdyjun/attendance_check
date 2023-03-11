package check.attendancecheck.controller;

import check.attendancecheck.entity.Member;
import check.attendancecheck.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;
    @PostMapping("/checksuccess")
    public void check(@RequestBody Member member) {
        checkService.save(member);
    }
}
