package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.*;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task1 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task1.class);

    @Override
    public void run(Text text) {

        log.info("Task #1");

        List<Sentence> result = new ArrayList<>();

        TextComponentIterator iterator = new TextComponentIterator(text.clone());

        while (iterator.hasNext()) {
            TextComponent component = iterator.next();
            if (component instanceof Sentence) {
                if (isSameWords((Sentence) component)) {
                    result.add((Sentence) component);
                }
            }
        }
        Printer.print(result, true);
    }

    /**
     * The method for checking the equivalence of words.
     *
     * @param sentence sentence.
     * @return boolean true if words are the same and false if not.
     */
    private boolean isSameWords(Sentence sentence) {
        List<Word> words = sentence.getWords();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i != j) {
                    if (words.get(i).equals(words.get(j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
