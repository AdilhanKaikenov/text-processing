package com.epam.adk.task2.text_processing.entity;

/**
 * Symbol class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 * @see Leaf
 * @see SentenceComponent
 */
public class Symbol implements Leaf, SentenceComponent {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toSourceString() {
        return String.valueOf(symbol);
    }

    @Override
    public String toString() {
        return toSourceString();
    }
}
