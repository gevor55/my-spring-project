package com.myspringproject.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {
    private String objectName;
    private String field;
    private String code;
    private String defaultMessage;
    private Object rejectedValue;
}
