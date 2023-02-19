package com.myspringproject.service.employee.impl;

import com.myspringproject.advice.NoSuchDataException;
import com.myspringproject.dto.employee.EmployeeRequestDto;
import com.myspringproject.dto.employee.EmployeeResponseDto;
import com.myspringproject.mapper.employee.EmployeeMapper;
import com.myspringproject.model.Employee;
import com.myspringproject.repository.EmployeeRepository;
import com.myspringproject.service.employee.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::entityToDto)
                .toList();

    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::entityToDto)
                .orElseThrow(() -> new NoSuchDataException("Employeee: " + id + " not found"));
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeMapper.dtoToEntity(employeeRequestDto);
        employeeRepository.save(employee);
        return employeeMapper.entityToDto(employee);
    }

    @Override
    public EmployeeResponseDto updateByFirstName(String firstName, EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeRepository.findByFirstName(firstName);
        if (employee == null) {
            throw new NoSuchDataException("Employeee: " + firstName + " not found");
        }
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setAge(employee.getAge());
        employee.setBirthday(employee.getBirthday());
        employeeRepository.save(employee);

        return employeeMapper.entityToDto(employee);
    }

    @Override
    public void deleteById(Long id) {
        log.trace("Starting delete cafe with id: {}.", id);

        employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchDataException("Cafe: " + id + " not found"));

        log.debug("Cafe with id: {} successfully deleted.", id);

        employeeRepository.deleteById(id);
    }
}
