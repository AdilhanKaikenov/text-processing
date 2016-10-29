package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Paragraph;
import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 3.Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task3 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task3.class);

    @Override
    public void run(Text text) {

        log.info("Task #3");

        List<Word> result = new ArrayList<>();

        Iterator<Paragraph> iterator = text.paragraphItr();
        Paragraph sentences = iterator.next();
        Sentence firstSentence = sentences.get(0);
        sentences.remove(firstSentence); //remove first sentence

        Set<Word> wordSet = new HashSet<>();
        List<Word> words = firstSentence.getWords();

        if (!words.isEmpty()) {
            wordSet.addAll(words);
        }

        for (Word word : wordSet) {
            if (isWordContains(word, sentences.getComponents())) {
                result.add(word);
            }
        }

        if (!result.isEmpty()) {
            log.info("These words aren't present in other sentences:");
            Printer.print(result, true);
        } else {
            log.info("<!> In the first sentence, there is no unique words. <!>\n");
        }
    }


    private boolean isWordContains(Word word, List<Sentence> sentences) {
        for (Sentence sentence : sentences) {
            List<Word> words = sentence.getWords();
            for (Word w : words) {
                if (word.equals(w)) {
                    return false;
                }
            }
        }
        return true;
    }
}
