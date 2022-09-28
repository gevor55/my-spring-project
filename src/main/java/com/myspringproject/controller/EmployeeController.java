package com.myspringproject.controller;

import com.myspringproject.dto.employee.EmployeeResponseDto;
import com.myspringproject.model.Employee;
import com.myspringproject.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponseDto findById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @PostMapping("/employees")
    public EmployeeResponseDto create(@RequestBody EmployeeResponseDto employeeResponseDto) {
        return employeeRepository.save(employeeResponseDto);
    }

    @PutMapping("/employees/{name}")
    public EmployeeResponseDto updateByFirstName(@PathVariable String name, @RequestBody EmployeeResponseDto employeeResponseDto) {
        return employeeRepository.save(name, employeeResponseDto);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable Long id) {
        return employeeRepository.deleteById(id);
    }


}
