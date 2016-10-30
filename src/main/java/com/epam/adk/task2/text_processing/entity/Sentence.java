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

    public Sentence() {
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

    /**
     * The method returns the first word of the sentence.
     *
     * @return the first word of the sentence.
     */
    public Word getFirstWord() {
        int index = 0;
        while (true) {
            SentenceComponent sentenceElement = this.get(index);
            if (sentenceElement != null && sentenceElement.getClass() == Word.class) {
                break;
            } else {
                index++;
            }
        }
        return (Word) this.get(index);
    }

    /**
     * The method returns the last word of the sentence.
     *
     * @return the last word of the sentence.
     */
    public Word getLastWord() {
        int index = getComponents().size() - 1;
        while (true) {
            SentenceComponent sentenceElement = this.get(index);
            if (sentenceElement != null && sentenceElement.getClass() == Word.class) {
                break;
            } else {
                index--;
            }
        }
        return (Word) this.get(index);
    }

    public int getNumberOfWords() {
        return getWords().size();
    }

    @Override
    public Sentence clone() {
        Sentence sentence = new Sentence();
        for (SentenceComponent component : this.getComponents()) {
            sentence.add(component);
        }
        return sentence;
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }

    public Iterator<SentenceComponent> sentenceComponentIterator(){
        return new SentenceComponentItr().iterator();
    }

    private class SentenceComponentItr extends ComponentIterable<SentenceComponent> {

        @Override
        public Iterator<SentenceComponent> iterator() {
            return getComponents().iterator();
        }
    }
}
