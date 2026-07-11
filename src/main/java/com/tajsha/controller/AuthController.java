package com.tajsha.controller;

import com.tajsha.model.User;
import com.tajsha.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Sign-up (Registration)
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    // Sign-in (Login)
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean isAuthenticated = authService.loginUser(user.getEmail(), user.getPassword());
        if (isAuthenticated) {
            return "Login Successful!";
        } else {
            return "Login Failed: Invalid Email or Password.";
        }
    }
}
