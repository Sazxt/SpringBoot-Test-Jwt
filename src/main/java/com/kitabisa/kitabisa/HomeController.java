package com.kitabisa.kitabisa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Home Page");
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
