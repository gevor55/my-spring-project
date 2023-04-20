package com.myspringproject.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@Log4j2
public class GlobalControllerAdvice {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ApiError> methodArgumentNotValid(final EmptyResultDataAccessException exception) {
        final ApiError apiError = ApiError.builder()
                .message("Required some parameter(s): " + exception.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .build();
        log.trace(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> methodArgumentNotValid(final NotFoundException exception) {
        final ApiError apiError = ApiError.builder()
                .message("Required some parameter(s): " + exception.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .build();
        log.trace(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}
