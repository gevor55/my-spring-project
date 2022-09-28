package com.myspringproject.service.employee;

import com.myspringproject.dto.employee.EmployeeRequestDto;
import com.myspringproject.dto.employee.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponseDto> findAll();

    EmployeeResponseDto findById(Long id);

    EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto updateByFirstName(String name, EmployeeRequestDto employeeRequestDto);

    void deleteById(Long id);
}
