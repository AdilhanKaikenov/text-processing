package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 10.Существует текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается
 * в каждом предложении, и рассортировать слова по убыванию общего количества вхождений.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task10 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task10.class);

    private List<Word> wordList;

    public Task10(List<Word> wordList) {
        this.wordList = wordList;
    }

    @Override
    public void run(Text text) {

        log.info("Task №10");

        Map<Word, Integer> result = new HashMap<>();

        for (Word word : wordList){
            result.put(word, count(text, word));
        }

        Map<Word, Integer> sorted = sort(result);
        print(sorted);

    }

    private static void print(Map<Word, Integer> map){
        for (Word word : map.keySet()){
            log.info("Word '{}' found {} times.", word, map.get(word));
        }
        System.out.println();
    }

    /**
     * The method for counting the word in a list words of sentence.
     *
     * @param sourceWord word.
     * @param text Text instance.
     * @return the number of specific word in the sentence.
     */
    private int count(Text text, Word sourceWord){
        int count = 0;

        Iterator<Word> iterator = text.wordItr();

        while (iterator.hasNext()){
            Word word = iterator.next();
            if (word.equals(sourceWord)){
                count++;
            }
        }
        return count;
    }

    /**
     * The method for sorting Map<Word, Integer> by values.
     *
     * @param map map for sorting.
     * @return sorted map.
     */
    private Map<Word, Integer> sort(Map<Word, Integer> map){

        ArrayList<Map.Entry<Word, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Word, Integer>>() {
            @Override
            public int compare(Map.Entry<Word, Integer> o1, Map.Entry<Word, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }.reversed()); // reversed

        Map<Word, Integer> result = new LinkedHashMap<>(); // LinkedHashMap

        for (Map.Entry<Word, Integer> entry: entries){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
