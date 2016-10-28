package com.epam.adk.task2.text_processing.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Text class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 */
public class Text extends AbstractComposite<Paragraph> {

    /**
     * The method returns all the paragraphs of the text.
     *
     * @return List<Paragraph> paragraphsList.
     */
    public List<Paragraph> getParagraphs() {
        return super.getComponents();
    }

    /**
     * The method returns all the sentences of the text.
     *
     * @return List<Sentence> sentencesList
     */
    public List<Sentence> getSentences(){
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : this.getParagraphs()){
            sentences.addAll(paragraph.getComponents());
        }
        return sentences;
    }

    /**
     * The method returns all the sentences of the text.
     *
     * @return List<Word> wordsList.
     */
    public List<Word> getWords(){
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : this.getSentences()){
            for (Component component : sentence.getComponents()){
                if (component != null && component.getClass() == Word.class){
                    words.add((Word) component);
                }
            }
        }
        return words;
    }
}
