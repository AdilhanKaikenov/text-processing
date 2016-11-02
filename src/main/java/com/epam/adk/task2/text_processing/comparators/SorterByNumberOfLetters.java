package com.epam.adk.task2.text_processing.comparators;

import com.epam.adk.task2.text_processing.entity.Word;

import java.util.Comparator;

/**
 * SorterByNumberOfLetters class Created on 29.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public final class SorterByNumberOfLetters implements Comparator<Word> {

    private Character specificLetter;

    public SorterByNumberOfLetters(Character specificLetter) {
        this.specificLetter = specificLetter;
    }

    @Override
    public int compare(Word wordOne, Word wordTwo) {

        Integer num1 = countLetters(wordOne, specificLetter);
        Integer num2 = countLetters(wordTwo, specificLetter);

        Integer i1 = (num1 * 1000) + wordOne.length();
        Integer i2 = (num2 * 1000) + wordTwo.length();

        if (i1 < i2) {
            return 1;
        } else if (i1 > i2){
            return -1;
        } else {
            return Character.compare(wordOne.charAt(0), wordTwo.charAt(0));
        }
    }

    /**
     * The method returns the number of a specific letter in the word.
     *
     * @param word word.
     * @param letter target letter to search for.
     * @return number of a specific letter in the word.
     */
    private Integer countLetters(Word word, Character letter){
        Integer count = 0;
        int length = word.length();

        for (int i = 0; i < length; i++){
            Character c = word.charAt(i);
            if ((Character.compare(c, letter)) == 0){
                count++;
            }
        }
        return count;
    }
}
