package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.comparators.SorterByNumberOfWords;
import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.TextComponent;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import com.epam.adk.task2.text_processing.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2.Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task2 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task2.class);

    @Override
    public void run(Text text) {

        log.info("Task #2");

        List<Sentence> result = new ArrayList<>();

        TextComponentIterator iterator = new TextComponentIterator(text.clone());
        while (iterator.hasNext()) {
            TextComponent component = iterator.next();
            if (component instanceof Sentence) {
                result.add((Sentence) component);
            }
        }

        Collections.sort(result, new SorterByNumberOfWords());

        Printer.print(result);
    }
}
