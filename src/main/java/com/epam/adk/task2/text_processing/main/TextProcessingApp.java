package com.epam.adk.task2.text_processing.main;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.exception.ParsingException;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.exception.ReadingException;
import com.epam.adk.task2.text_processing.io.TextReader;
import com.epam.adk.task2.text_processing.parse.RegexTextParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 22.10.2016.
 *
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public final class TextProcessingApp {

    private static final Logger log = LoggerFactory.getLogger(TextProcessingApp.class);

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) throws ReadingException, PropertyPathException, ParsingException {

        TextReader textReader = new TextReader();
        String text = textReader.read("text.txt", "utf-8");
//        log.info("\n{}", text);

        RegexTextParser textParser = new RegexTextParser();
        Text parse = textParser.parse(text);
        System.out.println(parse.toString());
/*

        TextReader reader = new TextReader();
        ... text = reader.read(pathParam, encoding);

        Preparer preparer = new Preparer();
        ... preparedText = preparer.prepareText(text);

        Parser parse = new Parser();
        Text parse = parse.parse(preparedText);

        TaskExecutor ...

 */

    }
}
