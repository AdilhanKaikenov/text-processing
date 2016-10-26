package com.epam.adk.task2.text_processing.entity;

/**
 * Symbol class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 * @see Leaf
 * @see SentenceElement
 */
public class Symbol implements Leaf, SentenceElement {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
