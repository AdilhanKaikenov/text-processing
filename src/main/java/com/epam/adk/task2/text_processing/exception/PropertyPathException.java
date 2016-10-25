package com.epam.adk.task2.text_processing.exception;

/**
 * PropertyPathException class created on 25.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
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
