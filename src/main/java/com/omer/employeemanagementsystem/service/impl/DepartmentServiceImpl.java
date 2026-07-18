package com.omer.employeemanagementsystem.service.impl;

import com.omer.employeemanagementsystem.dto.DepartmentDTO;
import com.omer.employeemanagementsystem.entity.Department;
import com.omer.employeemanagementsystem.repository.DepartmentRepository;
import com.omer.employeemanagementsystem.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO dto) {

        Department department = new Department();

        department.setName(dto.getName());

        Department saved = departmentRepository.save(department);

        return new DepartmentDTO(saved.getId(), saved.getName());
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentDTO(d.getId(), d.getName()))
                .toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department Not Found"));

        return new DepartmentDTO(
                department.getId(),
                department.getName()
        );
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department Not Found"));

        department.setName(dto.getName());

        Department updated = departmentRepository.save(department);

        return new DepartmentDTO(updated.getId(), updated.getName());
    }

    @Override
    public void deleteDepartment(Long id) {

        departmentRepository.deleteById(id);
    }
}