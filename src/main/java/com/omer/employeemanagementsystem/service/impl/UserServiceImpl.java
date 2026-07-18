package com.omer.employeemanagementsystem.service.impl;

import com.omer.employeemanagementsystem.dto.LoginDTO;
import com.omer.employeemanagementsystem.dto.RegisterDTO;
import com.omer.employeemanagementsystem.entity.User;
import com.omer.employeemanagementsystem.repository.UserRepository;
import com.omer.employeemanagementsystem.security.JwtService;
import com.omer.employeemanagementsystem.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public String register(RegisterDTO dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return "Email Already Exists";
        }

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public String login(LoginDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return jwtService.generateToken(user.getEmail());
    }
}