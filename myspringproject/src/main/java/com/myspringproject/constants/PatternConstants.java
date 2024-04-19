package com.myspringproject.constants;

import org.springframework.stereotype.Component;

@Component
public class PatternConstants {

    public static final String PASSWORD_PATTERN =
            "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
}
