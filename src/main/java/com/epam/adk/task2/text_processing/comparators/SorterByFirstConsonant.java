package com.epam.adk.task2.text_processing.comparators;

import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Properties;

/**
 * SorterByFirstConsonant class Created on 29.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public class SorterByFirstConsonant implements Comparator<Word> {

    private static final Logger log = LoggerFactory.getLogger(SorterByFirstConsonant.class);
    private static final String PARSER_REGEX_PROPERTIES = "parser-regex.properties";

    private Properties properties;

    public SorterByFirstConsonant() {
        if (properties == null){
            try {
                properties = new PropertyLoader().getProperties(PARSER_REGEX_PROPERTIES);
            } catch (PropertyPathException e) {
                log.error("Error in SorterByFirstConsonant() constrictor: {}", e);
            }
        }
    }

    @Override
    public int compare(Word wordOne, Word wordTwo) {
        Character firstConsonant = getFirstConsonant(wordOne);
        Character firstConsonant1 = getFirstConsonant(wordTwo);

        return firstConsonant.compareTo(firstConsonant1);
    }

    /**
     * The method returns the first consonant letter in the word.
     *
     * @param word word.
     * @return first consonant letter in the word.
     */
    private Character getFirstConsonant(Word word){

        int length = word.length();

        for (int i = 0; i < length; i++){
            String letter = Character.toString(word.charAt(i));
            if (letter.matches(properties.getProperty("consonant"))){
                return letter.charAt(0);
            }
        }
        return ' ';
    }
}