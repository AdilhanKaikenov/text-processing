package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
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

        Iterator<Sentence> iterator = text.sentenceItr();

        while (iterator.hasNext()){
            Sentence sentence = iterator.next();
            if (isSameWords(sentence)){
                result.add(sentence);
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
