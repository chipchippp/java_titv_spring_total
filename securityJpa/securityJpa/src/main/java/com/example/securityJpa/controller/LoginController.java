package com.example.securityJpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginPage")
    public String loginPage() {
        return "account/login";
    }
    @GetMapping("/showPage403")
    public String showPage403() {
        return "error/403";
    }

}
