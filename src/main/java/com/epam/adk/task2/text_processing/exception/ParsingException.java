package com.epam.adk.task2.text_processing.exception;

/**
 * ParsingException class created on 25.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public class ParsingException extends Exception {

    public ParsingException() {
        super();
    }

    public ParsingException(String message) {
        super(message);
    }

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
