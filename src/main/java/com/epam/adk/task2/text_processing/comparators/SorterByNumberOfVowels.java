package com.epam.adk.task2.text_processing.comparators;

import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Properties;

/**
 * SorterByNumberOfVowels class Created on 29.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public class SorterByNumberOfVowels implements Comparator<Word> {

    private static final Logger log = LoggerFactory.getLogger(SorterByNumberOfVowels.class);

    private Properties properties;
    private PropertyLoader loader = new PropertyLoader();

    public SorterByNumberOfVowels() {
        if (properties == null){
            try {
                properties = loader.getProperties("parser-regex.properties");
            } catch (PropertyPathException e) {
                log.error("Error in SorterByNumberOfVowels() constrictor: {}", e);
            }
        }
    }

    @Override
    public int compare(Word wordOne, Word wordTwo) {

        int numberOfVowels1 = getNumberOfVowels(wordOne);
        int numberOfVowels2 = getNumberOfVowels(wordTwo);

        Integer word1 = (numberOfVowels1 * 1000) + wordOne.length();
        Integer word2 = (numberOfVowels2 * 1000) + wordTwo.length();

        return word1.compareTo(word2);
    }

    /**
     * The method returns the number of vowels in the word.
     *
     * @param word word.
     * @return number of vowels in the word.
     */
    private int getNumberOfVowels(Word word) {

        int vowels = 0;

        for (int i = 0; i < word.length(); i++) {
            String letter = Character.toString(word.charAt(i));
            if (letter.toLowerCase().matches(properties.getProperty("vowels"))) {
                vowels++;
            }
        }
        return vowels;
    }
}
