package com.omer.employeemanagementsystem.service;

import com.omer.employeemanagementsystem.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long id);

    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);

    void deleteDepartment(Long id);

}