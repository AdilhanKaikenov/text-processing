package com.epam.adk.task2.text_processing.comparators;

import com.epam.adk.task2.text_processing.entity.Word;

import java.util.Comparator;

/**
 * SorterByAlphabetically class Created on 29.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public final class SorterByAlphabetically implements Comparator<Word>{

    @Override
    public int compare(Word wordOne, Word wordTwo) {

        Character c1 = wordOne.toString().toLowerCase().charAt(0);
        Character c2 = wordTwo.toString().toLowerCase().charAt(0);

        return c1.compareTo(c2);
    }
}
