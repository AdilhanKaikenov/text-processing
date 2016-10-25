package com.epam.adk.task2.text_processing.exception;

public class ReadingException extends Exception {

    public ReadingException() {
        super();
    }

    public ReadingException(String message) {
        super(message);
    }

    public ReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
