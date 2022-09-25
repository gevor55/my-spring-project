package com.myspringproject.advice;

public class NoSuchDataException extends RuntimeException {
    private String message;

    public NoSuchDataException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
