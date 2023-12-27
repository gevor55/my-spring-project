package com.myspringproject.advice;

public class ArgsCheck {

    private ArgsCheck() {
        throw new AssertionError("");
    }

    public static <T> T notNull(final T argument, final String name) {
        if (argument == null) {
            throw new NullPointerException(name + " may not be null");
        } else {
            return argument;
        }
    }
}
