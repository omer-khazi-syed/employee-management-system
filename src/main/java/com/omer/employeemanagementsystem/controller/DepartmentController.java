package com.omer.employeemanagementsystem.controller;

import com.omer.employeemanagementsystem.dto.DepartmentDTO;
import com.omer.employeemanagementsystem.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO dto) {
        return departmentService.saveDepartment(dto);
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentDTO updateDepartment(@PathVariable Long id,
                                          @RequestBody DepartmentDTO dto) {
        return departmentService.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}