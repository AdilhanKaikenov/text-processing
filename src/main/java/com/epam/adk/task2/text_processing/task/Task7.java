package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.comparators.SorterByNumberOfVowels;
import com.epam.adk.task2.text_processing.entity.*;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 7.Рассортировать слова текста по возрастанию доли гласных
 * букв (отношение количества гласных к общему количеству букв в слове).
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task7 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task7.class);

    @Override
    public void run(Text text) {

        log.info("Task #7");

        List<Word> words = new ArrayList<>();

        TextComponentIterator iterator = new TextComponentIterator(text.clone());

        while (iterator.hasNext()) {
            TextComponent component = iterator.next();
            if (component instanceof Sentence) {
                words.addAll(((Sentence) component).getWords());
            }
        }
        words.sort(new SorterByNumberOfVowels());
        Printer.print(words, true);
    }
}
