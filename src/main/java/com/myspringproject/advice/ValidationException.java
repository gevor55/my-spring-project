package com.myspringproject.advice;

import java.util.Collection;
import java.util.Collections;

public class ValidationException extends RuntimeException {

    private final transient Collection<Error> errors;

    public ValidationException(Collection<Error> e) {
        this.errors = e;
    }

    public ValidationException(Error e) {
        this.errors = Collections.singleton(e);
    }

    public Collection<Error> getErrors() {
        return this.errors;
    }

    public String toString() {
        return "ValidationException(errors=" + this.getErrors() + ")";
    }
}
