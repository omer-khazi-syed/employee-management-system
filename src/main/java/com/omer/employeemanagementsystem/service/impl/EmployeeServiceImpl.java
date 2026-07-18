package com.omer.employeemanagementsystem.service.impl;

import com.omer.employeemanagementsystem.dto.EmployeeDTO;
import com.omer.employeemanagementsystem.entity.Department;
import com.omer.employeemanagementsystem.entity.Employee;
import com.omer.employeemanagementsystem.repository.DepartmentRepository;
import com.omer.employeemanagementsystem.repository.EmployeeRepository;
import com.omer.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department Not Found"));

        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);

        return new EmployeeDTO(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getSalary(),
                saved.getDepartment().getId()
        );
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(employee -> new EmployeeDTO(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail(),
                        employee.getPhone(),
                        employee.getSalary(),
                        employee.getDepartment().getId()
                ))
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getSalary(),
                employee.getDepartment().getId()
        );
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department Not Found"));

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        Employee updated = employeeRepository.save(employee);

        return new EmployeeDTO(
                updated.getId(),
                updated.getFirstName(),
                updated.getLastName(),
                updated.getEmail(),
                updated.getPhone(),
                updated.getSalary(),
                updated.getDepartment().getId()
        );
    }

    @Override
    public String deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employeeRepository.delete(employee);

        return "Employee Deleted Successfully";
    }
}