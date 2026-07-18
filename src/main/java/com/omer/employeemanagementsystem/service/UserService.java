package com.omer.employeemanagementsystem.service;

import com.omer.employeemanagementsystem.dto.LoginDTO;
import com.omer.employeemanagementsystem.dto.RegisterDTO;

public interface UserService {

    String register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);

}