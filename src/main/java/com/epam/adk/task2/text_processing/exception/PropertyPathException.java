package com.epam.adk.task2.text_processing.exception;

public class PropertyPathException extends Exception {

    public PropertyPathException() {
        super();
    }

    public PropertyPathException(String message) {
        super(message);
    }

    public PropertyPathException(String message, Throwable cause) {
        super(message, cause);
    }
}
