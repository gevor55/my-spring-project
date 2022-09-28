package com.myspringproject.service.employee.impl;

import com.myspringproject.advice.NoSuchDataException;
import com.myspringproject.dto.employee.EmployeeRequestDto;
import com.myspringproject.dto.employee.EmployeeResponseDto;
import com.myspringproject.mapper.EmployeeMapper;
import com.myspringproject.model.Employee;
import com.myspringproject.repository.EmployeeRepository;
import com.myspringproject.service.employee.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponseDtos.add(EmployeeMapper.toResponse(employee));
        }

        return employeeResponseDtos;
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(null);
        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        Employee employee = EmployeeMapper.toEntity(employeeRequestDto);
        employeeRepository.save(employee);
        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponseDto updateByFirstName(String name, EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeRepository.findByFirstName(name);
        if (employee == null) {
            throw new RuntimeException("no");
        }
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setAge(employee.getAge());
        employee.setBirthday(employee.getBirthday());
        employeeRepository.save(employee);

        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new NoSuchDataException("Not found " + id);
        }
        employeeRepository.deleteById(id);
    }
}
