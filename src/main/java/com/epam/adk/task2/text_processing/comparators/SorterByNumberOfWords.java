package com.epam.adk.task2.text_processing.comparators;

import com.epam.adk.task2.text_processing.entity.Sentence;

import java.util.Comparator;

/**
 * SorterByNumberOfWords class Created on 29.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public class SorterByNumberOfWords implements Comparator<Sentence> {

    @Override
    public int compare(Sentence sentenceOne, Sentence sentenceTwo) {

        Integer numberOfWord1 = sentenceOne.getNumberOfWords();
        Integer numberOfWord2 = sentenceTwo.getNumberOfWords();

        return numberOfWord1.compareTo(numberOfWord2);
    }
}