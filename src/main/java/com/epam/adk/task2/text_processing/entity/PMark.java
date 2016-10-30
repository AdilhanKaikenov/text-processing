package com.epam.adk.task2.text_processing.entity;

/**
 * PMark class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComposite
 * @see SentenceComponent
 */
public class PMark extends AbstractTextComposite<Symbol> implements SentenceComponent {

    public PMark() {
    }

    public PMark(Symbol symbol){
        this.add(symbol);
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }
}
