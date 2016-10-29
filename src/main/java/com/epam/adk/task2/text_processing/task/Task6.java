package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.comparators.SorterByAlphabetically;
import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 6.Напечатать слова текста в алфавитном порядке по первой букве.
 * Слова, начинающиеся с новой буквы, печатать с красной строки.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task6 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task6.class);

    @Override
    public void run(Text text) {

        log.info("Task #6");

        List<Word> result = new ArrayList<>();

        Iterator<Sentence> iterator = text.sentenceItr();
        while (iterator.hasNext()){
            result.addAll(iterator.next().getWords());
        }
        result.sort(new SorterByAlphabetically());

        print(result);
    }

    /**
     * The method for displaying the words in according to the task.
     *
     * @param words list of words.
     */
    private void print(List<Word> words) {
        StringBuilder sb = new StringBuilder();
        Character prevFirstChar, currFirstChar, mark = ',';
        int countInRow = 0;
        for (int i = 0; i < words.size(); i++) {

            // Условие чтобы вначале один раз поставил красную строку
            if (i == 0){
                sb.append("\t- ");
            }

            // Условие для того чтобы поставить точку на последнем слове
            if ((i == words.size() - 1)){
                mark = '.';
            }

            // Флажок сообщаюий был ли перенос
            boolean isRed = false;

            // Условие для плучение предыдущего и текущего символа
            if ((i - 1) < 1) {
                prevFirstChar = words.get(i).toString().toLowerCase().charAt(0);
            } else {
                prevFirstChar = words.get(i - 1).toString().toLowerCase().charAt(0);
            }
            currFirstChar = words.get(i).toString().toLowerCase().charAt(0);

            // Условие для подсчета слов в строке
            if (countInRow == 6) {
                sb.append("\n");
                isRed = true;
                countInRow = 1;
            } else {
                countInRow++;
            }

            // Условие на сравнение первых символов в словах
            if (currFirstChar == prevFirstChar) {
                sb.append(words.get(i)).append(mark).append(" ");
            } else {
                if (!isRed) {
                    sb.append("\n");
                    countInRow = 1;
                }
                sb.append("\t- ").append(words.get(i)).append(mark).append(" ");
            }
        }
        log.info("\n{}\n", sb);
    }
}
