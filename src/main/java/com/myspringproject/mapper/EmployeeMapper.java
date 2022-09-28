package com.myspringproject.mapper;

import com.myspringproject.dto.employee.EmployeeRequestDto;
import com.myspringproject.dto.employee.EmployeeResponseDto;
import com.myspringproject.model.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employee.setBirthday(dto.getBirthday());

        return employee;
    }

    public static EmployeeResponseDto toResponse(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setAge(employee.getAge());
        employeeResponseDto.setBirthday(employee.getBirthday());

        return employeeResponseDto;
    }
}
