package com.epam.adk.task2.text_processing.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Symbol class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 * @see Leaf
 * @see SentenceComponent
 */
public class Symbol implements Leaf, SentenceComponent {

    private static final Logger log = LoggerFactory.getLogger(Symbol.class);

    /**
     * @param cache cache of symbols.
     */
    private static Map<Character, Symbol> cache;
    private Character symbol;

    private Symbol(Character symbol) {
        this.symbol = symbol;
    }

    /**
     * Symbol Factory method.
     *
     * @param ch char
     * @return Symbol
     */
    public static Symbol of(char ch) {

        if (cache == null) {
            cache = new HashMap<>();
        }

        Symbol symbol = cache.get(ch);

        if (symbol == null) {
            cache.put(ch, new Symbol(ch));
        }
        return symbol;
    }

    @Override
    public String toSourceString() {
        return String.valueOf(symbol);
    }

    @Override
    public void toSourceString(StringBuilder builder) {
        toSourceString();
    }

    @Override
    public String toString() {
        return toSourceString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;

    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }

}
