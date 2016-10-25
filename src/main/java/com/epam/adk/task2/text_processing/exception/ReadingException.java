package com.epam.adk.task2.text_processing.exception;

/**
 * ReadingException class created on 25.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
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
