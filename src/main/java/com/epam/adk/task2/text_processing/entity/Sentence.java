package com.epam.adk.task2.text_processing.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sentence class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComposite
 */
public class Sentence extends AbstractTextComposite<SentenceComponent> {

    private SentenceComponentItr sentenceComponentItr;
    private int numberOfWords;

    public Sentence() {
        sentenceComponentItr = new SentenceComponentItr();
    }

    /**
     * The method returns all the words in the sentence.
     *
     * @return List<Word> wordsList.
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        Iterator<SentenceComponent> iterator = sentenceComponentIterator();
        while (iterator.hasNext()){
            SentenceComponent component = iterator.next();
            if (component != null && component.getClass() == Word.class) {
                words.add((Word) component);
            }
        }
        return words;
    }

    /**
     * The method returns all the punctuation marks in the sentence.
     *
     * @return List<PMark> punctuationMarksList.
     */
    public List<PMark> getPMarks() {
        List<PMark> pMarks = new ArrayList<>();
        Iterator<SentenceComponent> iterator = sentenceComponentIterator();
        while (iterator.hasNext()){
            SentenceComponent component = iterator.next();
            if (component != null && component.getClass() == PMark.class) {
                pMarks.add((PMark) component);
            }
        }
        return pMarks;
    }

    public int getNumberOfWords() {
        numberOfWords = getWords().size();
        return numberOfWords;
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }

    public Iterator<SentenceComponent> sentenceComponentIterator(){
        return sentenceComponentItr.iterator();
    }

    private class SentenceComponentItr implements ComponentIterable<SentenceComponent> {

        @Override
        public Iterator<SentenceComponent> iterator() {
            return getComponents().iterator();
        }
    }
}
