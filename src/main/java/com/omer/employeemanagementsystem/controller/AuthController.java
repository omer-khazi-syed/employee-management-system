package com.omer.employeemanagementsystem.controller;

import com.omer.employeemanagementsystem.dto.LoginDTO;
import com.omer.employeemanagementsystem.dto.RegisterDTO;
import com.omer.employeemanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return userService.login(dto);
    }
}