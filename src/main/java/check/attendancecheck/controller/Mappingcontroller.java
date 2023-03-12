package check.attendancecheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String result(@RequestParam(name = "resultTitle", required = true) String resultTitle,
                         @RequestParam(name = "resultHeader", required = true) String resultHeader,
                         @RequestParam(name = "icon", required = true) String icon,
                         @RequestParam(name = "iconColor", required = true) String iconColor,
                         Model model) {
        model.addAttribute("resultTitle", resultTitle);
        model.addAttribute("resultHeader", resultHeader);
        model.addAttribute("icon", icon);
        model.addAttribute("iconColor", iconColor);
        return "result";
    }
}
