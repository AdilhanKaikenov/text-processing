package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.comparators.SorterByFirstConsonant;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * 8.Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task8 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task8.class);
    private static final String PARSER_REGEX_PROPERTIES = "parser-regex.properties";
    private Properties properties;

    public Task8() {
        if (properties == null) {
            try {
                properties = new PropertyLoader().getProperties(PARSER_REGEX_PROPERTIES);
            } catch (PropertyPathException e) {
                log.error("Error in Task8() constrictor: {}", e);
            }
        }
    }

    @Override
    public void run(Text text) {

        log.info("Task #8");
        List<Word> firstLetterVowelWords = new ArrayList<>();

        Iterator<Word> iterator = text.wordItr();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            if (isWordsBeginVowel(word)) {
                firstLetterVowelWords.add(word);
            }
        }
        firstLetterVowelWords.sort(new SorterByFirstConsonant());
        Printer.print(firstLetterVowelWords, true);
    }

    /**
     * The method for sampling all the words that start with a vowel.
     *
     * @param word list of words.
     * @return The words beginning with a vowel.
     */
    private boolean isWordsBeginVowel(Word word) {
        String charAsString = Character.toString(word.charAt(0));
        if (charAsString.toLowerCase().matches(properties.getProperty("vowels")) && !isAllVowels(word)) {
            return true;
        }
        return false;
    }

    /**
     * The method for checking whether the word is composed entirely of vowels.
     *
     * @param word word.
     * @return boolean true if the word is composed entirely of vowels and false if not.
     */
    private boolean isAllVowels(Word word) {
        int wordLength = word.length();
        boolean result = false;

        for (int i = 0; i < wordLength; i++) {
            String w = Character.toString(word.charAt(i));
            if (w.matches(properties.getProperty("consonant"))) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
