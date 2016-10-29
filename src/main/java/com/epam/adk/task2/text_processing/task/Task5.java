package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.SentenceComponent;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 5.В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task5 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task5.class);

    @Override
    public void run(Text text) {

        log.info("Task #5");

        int indexOfFirst = 0;
        int indexOfLast = 0;

        Iterator<Sentence> iterator = text.sentenceItr();
        while (iterator.hasNext()) {
            Sentence sentence = iterator.next();
            List<SentenceComponent> components = sentence.getComponents();

            Word firstWord = sentence.getFirstWord(); // the first word
            Word lastWord = sentence.getLastWord(); // the last word

            indexOfFirst = components.indexOf(firstWord); // index of the first word
            indexOfLast = components.lastIndexOf(lastWord); // index of the last word

            // move the first and last word
            sentence.set(indexOfFirst, lastWord);
            sentence.set(indexOfLast, firstWord);

            Printer.print(sentence);
        }
        log.info("");
    }
}
