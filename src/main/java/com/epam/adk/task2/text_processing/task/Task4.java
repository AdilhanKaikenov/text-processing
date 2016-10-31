package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.*;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 4.Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task4 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task4.class);

    int from;
    int to;

    public Task4(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run(Text text) {

        log.info("Task #4");

        List<Sentence> interrogativeSentences = new ArrayList<>();

        TextComponentIterator iterator = new TextComponentIterator(text.clone());

        PMark questionMark = new PMark(Symbol.of('?'));
        while (iterator.hasNext()) {
            TextComponent component = iterator.next();
            if (component instanceof Sentence) {
                Sentence sentence = (Sentence) component;
                if (sentence.getPMarks().contains(questionMark)) {
                    interrogativeSentences.add(sentence);
                }
            }
        }

        Set<Word> wordSet = new HashSet<>();
        wordSet.addAll(giveWordsOfTheSpecifiedLength(interrogativeSentences));

        log.info("Interrogative sentences:");
        Printer.print(interrogativeSentences);
        log.info("The words in length range from {} to {}.", from, to);
        Printer.print(wordSet, true);
    }

    /**
     * The method for getting all the words of a certain length.
     *
     * @param sentences sentence.
     * @return words required length.
     */
    private List<Word> giveWordsOfTheSpecifiedLength(List<Sentence> sentences) {
        List<Word> result = new ArrayList<>();
        for (Sentence sentence : sentences) {
            for (Word word : sentence.getWords()) {
                int length = word.length();
                if (length >= from && length <= to) {
                    result.add(word);
                }
            }
        }
        return result;
    }
}
