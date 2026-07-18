package com.omer.employeemanagementsystem.dto;

import com.omer.employeemanagementsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    private String name;

    private String email;

    private String password;

    private Role role;

}