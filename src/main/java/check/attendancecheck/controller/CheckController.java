package check.attendancecheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckController {
    @GetMapping("check")
    public String check(Model model){
        model.addAttribute("data", "hello!!");
        return "check";
    }
}
