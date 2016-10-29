package com.epam.adk.task2.text_processing.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Symbol class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComposite
 * @see TextLeaf
 * @see SentenceComponent
 */
public class Symbol implements TextLeaf, SentenceComponent {

    private static final Logger log = LoggerFactory.getLogger(Symbol.class);

    /**
     * @param cache cache of symbols to store codes of ASCII symbols from 32 to 128.
     */
    private static final Symbol[] cache = new Symbol[127 + 1];
    private Character symbol;

    private Symbol(Character symbol) {
        this.symbol = symbol;
    }

    static {
        loadCache();
    }

    private static void loadCache(){
        for (int i = 32; i < cache.length; i++) {
            cache[i] = new Symbol((char) i);
        }
        log.debug("Cache of symbols loaded. Cache length = {}.", cache.length);
    }

    /**
     * Symbol Factory method.
     *
     * @param symbol char
     * @return Symbol
     */
    public static Symbol of(char symbol) {

        if (cache.length < (int) symbol) {
            log.debug("Symbol '{}' is not present in the cache of symbols.", symbol);
            return new Symbol(symbol);
        } else {
            return cache[symbol];
        }
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
