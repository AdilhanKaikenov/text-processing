package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.comparators.SorterByNumberOfLetters;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.TextComponent;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 9.Все слова текста рассортировать по возрастанию количества заданной буквы в слове.
 * Слова с одинаковым количеством расположить в алфавитном порядке.
 * 13.Отсортировать слова в тексте по убыванию количества вхождений заданного символа,
 * а в случае равенства – по алфавиту.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task9_13 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task9_13.class);

    private Direction direction;
    private char ch;

    public Task9_13(char ch, Direction direction) {
        this.ch = ch;
        this.direction = direction;
    }

    @Override
    public void run(Text text) {

        log.info("Task #9 && #13");

        List<Word> result = new ArrayList<>();

        TextComponentIterator iterator = new TextComponentIterator(text.clone());
        while (iterator.hasNext()) {
            TextComponent component = iterator.next();
            if (component instanceof Word) {
                result.add((Word) component);
            }
        }

        switch (direction) {
            case INCREASE:
                result.sort(new SorterByNumberOfLetters(ch).reversed());
                break;
            case DECREASE:
                result.sort(new SorterByNumberOfLetters(ch));
                break;
        }
        Printer.print(result, true);
    }

    /**
     * Inner enum class Direction.
     */
    public enum Direction {

        INCREASE, DECREASE

    }
}
