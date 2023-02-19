package com.myspringproject.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime birthday;
}
