package com.omer.employeemanagementsystem.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(String email) {

        return "JWT_TOKEN";

    }
}