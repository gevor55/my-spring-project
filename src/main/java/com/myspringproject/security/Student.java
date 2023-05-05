package com.myspringproject.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    private final Integer studentId;
    private final String studentName;
}
