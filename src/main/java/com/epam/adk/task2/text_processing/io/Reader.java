package com.epam.adk.task2.text_processing.io;

/**
 * Interface created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public interface Reader<T> {

    T read(String fileName, String encoding);
}
