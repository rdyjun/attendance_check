package check.attendancecheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mappingcontroller {
    @GetMapping("/check")
    public String check(){
        return "check.html";
    }
    @GetMapping("/")
    public String mn () {
        return "index";
    }
}
