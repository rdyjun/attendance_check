package check.attendancecheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mappingcontroller {
    @GetMapping("/check")
    public String check(){
        return "check";
    }
    @GetMapping("/")
    public String mn () {
        return "index";
    }
    @GetMapping("/result")
    public String result(Model model) {
        return "result";
    }
}
