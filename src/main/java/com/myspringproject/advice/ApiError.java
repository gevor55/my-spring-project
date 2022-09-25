package com.myspringproject.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
    private String message;
    private Integer code;
    private String error;
    private LocalDateTime timestamp;
    private String exception;
    private String trace;
}
