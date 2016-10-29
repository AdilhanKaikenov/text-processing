package com.epam.adk.task2.text_processing.main;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.exception.ParsingException;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.exception.ReadingException;
import com.epam.adk.task2.text_processing.io.TextReader;
import com.epam.adk.task2.text_processing.parse.RegexTextParser;
import com.epam.adk.task2.text_processing.task.*;
import com.epam.adk.task2.text_processing.util.TaskExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 22.10.2016.
 * <p>
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public final class TextProcessingApp {

    private static final Logger log = LoggerFactory.getLogger(TextProcessingApp.class);

    private static final int FILE_PATH = 0;
    private static final int CHARSET = 1;

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) throws ReadingException, PropertyPathException, ParsingException {

        if (args.length != 2) {
            throw new IllegalArgumentException("Specify the file path and charset");
        }

        String pathParam = args[FILE_PATH];
        String charsetName = args[CHARSET];

        TextReader reader = new TextReader();
        String sourceString = reader.read(pathParam, charsetName);
        log.info("\nSOURCE TEXT: {}", sourceString);

        RegexTextParser textParser = new RegexTextParser();
        Text parsedText = textParser.parse(sourceString);
        log.info("\nPARSED TEXT: {}", parsedText);

        List<Word> words = Arrays.asList(
                new Word("Nulla"),
                new Word("et"),
                new Word("elit")
        );

        TaskExecutor.performTask(
                Arrays.asList(
                        new Task1(),
                        new Task2(),
                        new Task3(),
                        new Task4(4,5),
                        new Task5(),
                        new Task6(),
                        new Task7(),
                        new Task8(),
                        new Task10(words)
                ),
                parsedText);
    }
}