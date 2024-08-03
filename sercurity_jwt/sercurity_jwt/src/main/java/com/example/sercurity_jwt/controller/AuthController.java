package com.example.sercurity_jwt.controller;

import com.example.sercurity_jwt.entity.UserEntity;
import com.example.sercurity_jwt.payload.Token;
import com.example.sercurity_jwt.payload.UserLogin;
import com.example.sercurity_jwt.service.TokenService;
import com.example.sercurity_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @GetMapping("/token")
    public Token generateToken(@RequestBody UserLogin userLogin) {
        if (userLogin.getUsername() == null || userLogin.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and password cannot be null");
        }

        UserEntity user = userService.findByName(userLogin.getUsername());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);

        String token = tokenService.GenerateToken(auth);
        return new Token(token);
    }
}
