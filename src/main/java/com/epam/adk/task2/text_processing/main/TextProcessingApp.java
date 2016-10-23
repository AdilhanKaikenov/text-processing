package com.epam.adk.task2.text_processing.main;

import com.epam.adk.task2.text_processing.io.Reader;
import com.epam.adk.task2.text_processing.io.TextReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 22.10.2016.
 *
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public class TextProcessingApp {

    private static final Logger log = LoggerFactory.getLogger(TextProcessingApp.class);

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) {

        Reader<String> textReader = new TextReader();
        String text = textReader.read("text.txt", "utf-8");
        log.info("\n{}", text);

/*

        TextReader reader = new TextReader();
        ... text = reader.read(pathParam, encoding);

        Preparer preparer = new Preparer();
        ... preparedText = preparer.prepareText(text);

        Parser parser = new Parser();
        Text parse = parser.parse(preparedText);

        TaskExecutor ...

 */
    }
}
