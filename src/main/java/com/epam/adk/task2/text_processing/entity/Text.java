package com.epam.adk.task2.text_processing.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Text class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 */
public class Text extends AbstractComposite<Paragraph> {

    private ParagraphItr paragraphItr;
    private SentenceItr sentenceItr;
    private WordItr wordItr;

    public Text() {
        paragraphItr = new ParagraphItr();
        sentenceItr = new SentenceItr();
        wordItr = new WordItr();
    }

    /**
     * The method returns all the sentences of the text.
     *
     * @return List<Sentence> sentencesList
     */
    private List<Sentence> getSentences() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : this.getComponents()) {
            sentences.addAll(paragraph.getComponents());
        }
        return sentences;
    }

    /**
     * The method returns all the sentences of the text.
     *
     * @return List<Word> wordsList.
     */
    private List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : this.getSentences()) {
            for (Component component : sentence.getComponents()) {
                if (component != null && component.getClass() == Word.class) {
                    words.add((Word) component);
                }
            }
        }
        return words;
    }

    public Iterator<Paragraph> paragraphItr() {
        return paragraphItr.iterator();
    }

    public Iterator<Sentence> sentenceItr() {
        return sentenceItr.iterator();
    }

    public Iterator<Word> wordItr() {
        return wordItr.iterator();
    }


    private class ParagraphItr implements ComponentIterable<Paragraph> {

        @Override
        public Iterator<Paragraph> iterator() {
            return getComponents().iterator();
        }
    }

    private class SentenceItr implements ComponentIterable<Sentence> {

        @Override
        public Iterator<Sentence> iterator() {
            return getSentences().iterator();
        }
    }

    private class WordItr implements ComponentIterable<Word> {

        @Override
        public Iterator<Word> iterator() {
            return getWords().iterator();
        }
    }
}
