package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.*;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ListIterator;

/**
 * 15.Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие)
 * вхождения первой (последней) буквы этого слова.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task15 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task15.class);

    private Position from;

    public Task15(Position from) {
        this.from = from;
    }

    @Override
    public void run(Text text) {

        log.info("Task #15");

        Text textClone = text.clone();

        TextComponentIterator iterator = new TextComponentIterator(textClone);

        while (iterator.hasNext()) {

            TextComponent component = iterator.next();
            if (component instanceof Word) {
                Word word = (Word) component;

                int fistIndex = 0;
                int lastIndex = word.length() - 1;

                ListIterator<Symbol> symbolListIterator = word.getComponents().listIterator();

                switch (from) {
                    case FROM_FIRSTS:

                        Symbol firstSymbol = Symbol.of(word.charAt(fistIndex));

                        Symbol first = symbolListIterator.next();

                        while (symbolListIterator.hasNext()) {

                            Symbol symbol = symbolListIterator.next();

                            if (firstSymbol.equals(symbol)) {
                                symbolListIterator.remove();
                            }
                        }
                        break;
                    case FROM_LAST:
                        Symbol lastSymbol = Symbol.of(word.charAt(lastIndex));

                        while (symbolListIterator.hasNext()) {
                            Symbol next = symbolListIterator.next();
                        }

                        Symbol previous = symbolListIterator.previous();

                        while (symbolListIterator.hasPrevious()) {

                            Symbol previousSymbol = symbolListIterator.previous();

                            if (lastSymbol.equals(previousSymbol)) {
                                symbolListIterator.remove();
                            }
                        }
                        break;
                }
            }
        }
        Printer.print(textClone);
    }

    /**
     * Inner enum class Position.
     */
    public enum Position {

        FROM_FIRSTS, FROM_LAST

    }
}


