package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.TextComponent;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 12.Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task12 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task12.class);
    private static final String PARSER_REGEX_PROPERTIES = "parser-regex.properties";
    private Properties properties;
    private int length;

    public Task12(int length) {
        if (properties == null) {
            try {
                properties = new PropertyLoader().getProperties(PARSER_REGEX_PROPERTIES);
            } catch (PropertyPathException e) {
                log.error("Error in Task12() constrictor: {}", e);
            }
        }
        this.length = length;
    }

    @Override
    public void run(Text text) {

        log.info("Task #12");

        Text textClone = text.clone();

        TextComponentIterator iterator = new TextComponentIterator(textClone);

        while (iterator.hasNext()) {
            TextComponent component = iterator.next();
            if (component instanceof Word) {
                int length = ((Word) component).length();
                if (isFirstConsonant((Word) component) && length == this.length) {
//                    iterator.remove(); // TODO: remove default UnsupportedOperationException()
                }
            }
        }
        Printer.print(textClone);
    }

    /**
     * The method to check for the word begins with a consonant or not.
     *
     * @param word word
     * @return boolean true if the first letter of word is consonant and false if not.
     */
    private boolean isFirstConsonant(Word word) {
        String w = word.toString();
        if (w.matches(properties.getProperty("isFirstConsonant"))) {
            return true;
        }
        return false;
    }
}
