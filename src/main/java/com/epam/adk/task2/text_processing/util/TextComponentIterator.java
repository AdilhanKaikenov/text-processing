package com.epam.adk.task2.text_processing.util;

import com.epam.adk.task2.text_processing.entity.AbstractTextComposite;
import com.epam.adk.task2.text_processing.entity.TextComponent;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Iterator TextComponentIterator class created on 31.10.2016.
 */
public final class TextComponentIterator implements Iterator<TextComponent> {
    private Deque<TextComponent> stack = new LinkedList<>();

    public TextComponentIterator(TextComponent root) {
        stack.add(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TextComponent next() {

        TextComponent node = stack.pop();
        if (node != null) {
            if (node instanceof AbstractTextComposite) {
                AbstractTextComposite composite = (AbstractTextComposite) node;
                for (Object object : composite.getComponents())
                    stack.add((TextComponent) object);
            }
        }
        return node;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}

