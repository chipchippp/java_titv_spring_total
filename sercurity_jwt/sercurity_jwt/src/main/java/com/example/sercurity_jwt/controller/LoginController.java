package com.example.sercurity_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class LoginController {
    @GetMapping("/loginPage")
    public String loginPage() {
        return "account/login";
    }
}
