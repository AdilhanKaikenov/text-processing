package com.epam.adk.task2.text_processing.io;

import com.epam.adk.task2.text_processing.exception.ReadingException;

/**
 * Interface created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public interface Reader {

    String read(String fileName, String encoding) throws ReadingException;
}
