package com.epam.adk.task2.text_processing.entity;

import java.util.List;

/**
 * Paragraph class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 */
public class Paragraph extends AbstractComposite<Sentence> {

    @Override
    public String toSourceString() {
        int index = 0;
        List<Sentence> components = getComponents();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            index = i;
            Sentence sentence = components.get(i);
            if (sentence != null) {
                builder.append(sentence.toSourceString());
            }
        }
        builder.append((index != components.size()) ? "\n" : "");
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }
}
