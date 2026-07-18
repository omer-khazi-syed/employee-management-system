package com.omer.employeemanagementsystem.service;

import com.omer.employeemanagementsystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    String deleteEmployee(Long id);

}