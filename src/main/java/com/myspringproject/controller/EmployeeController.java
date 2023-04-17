//package com.myspringproject.controller;
//
//import com.myspringproject.dto.employee.EmployeeRequestDto;
//import com.myspringproject.dto.employee.EmployeeResponseDto;
//import com.myspringproject.service.employee.EmployeeService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeController {
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//
//    @GetMapping("/employees")
//    public List<EmployeeResponseDto> findAll() {
//        return employeeService.findAll();
//    }
//
//    @GetMapping("/employees/{id}")
//    public EmployeeResponseDto findById(@PathVariable Long id) {
//        return employeeService.findById(id);
//    }
//
//    @PostMapping("/employees")
//    public EmployeeResponseDto create(@RequestBody EmployeeRequestDto employeeRequestDto) {
//        return employeeService.create(employeeRequestDto);
//    }
//
//    @PutMapping("/employees/{firstName}")
//    public EmployeeResponseDto updateByFirstName(@PathVariable String firstName, @RequestBody EmployeeRequestDto employeeRequestDto) {
//        return employeeService.updateByFirstName(firstName, employeeRequestDto);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public void deleteById(@PathVariable Long id) {
//        employeeService.deleteById(id);
//    }
//
//
//}
