package com.epam.adk.task2.text_processing.entity;

import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Properties;

/**
 * Word class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 * @see SentenceComponent
 */
public class Word extends AbstractComposite<Symbol> implements SentenceComponent {

    private static final Logger log = LoggerFactory.getLogger(Word.class);
    private static final String PARSER_REGEX_PROPERTIES = "parser-regex.properties";

    private static PropertyLoader loader = new PropertyLoader();

    public Word() {
    }

    public Word(String word) throws PropertyPathException {
        Properties properties = loader.getProperties(PARSER_REGEX_PROPERTIES);
        if (word.matches(properties.getProperty("word"))) {
            for (int i = 0; i < word.length(); i++) {
                this.add(Symbol.of(word.charAt(i)));
            }
        } else {
            log.error(
                    "Error in constructor: Word(String word) - argument = '{}'. You can not enter a few words and punctuations.", word);
            throw new IllegalArgumentException(MessageFormat.format(
                    "Error in constructor: Word(String word) - argument = {0}. You can not enter a few words and punctuations.", word));
        }
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }
}
