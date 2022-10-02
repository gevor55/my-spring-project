package com.myspringproject.mapper.employee;

import com.myspringproject.dto.employee.EmployeeRequestDto;
import com.myspringproject.dto.employee.EmployeeResponseDto;
import com.myspringproject.model.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class EmployeeMapper {

    public Employee dtoToEntity(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employee.setBirthday(dto.getBirthday());

        return employee;
    }

    public EmployeeResponseDto entityToDto(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setAge(employee.getAge());
        employeeResponseDto.setBirthday(employee.getBirthday());

        return employeeResponseDto;
    }
}
