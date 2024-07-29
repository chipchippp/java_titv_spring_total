package com.example.sercurity_jwt.controller;

import com.example.sercurity_jwt.entity.Members;
import com.example.sercurity_jwt.payload.Token;
import com.example.sercurity_jwt.payload.UserLogin;
import com.example.sercurity_jwt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @GetMapping("/token")
    public String GenerateToken(@RequestBody Members userLogin) {
        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return tokenService.GenerateToken(auth);
    }
}
