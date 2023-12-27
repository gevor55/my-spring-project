package com.myspringproject.advice;

import java.util.Collection;
import java.util.Collections;

public class CustomValidationException extends RuntimeException {

    private final transient Collection<Error> errors;

    public CustomValidationException(Collection<Error> e) {
        this.errors = e;
    }

    public CustomValidationException(Error e) {
        this.errors = Collections.singleton(e);
    }

    public Collection<Error> getErrors() {
        return this.errors;
    }

    public String toString() {
        return "ValidationException(errors=" + this.getErrors() + ")";
    }
}
