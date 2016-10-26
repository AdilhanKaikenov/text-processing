package com.epam.adk.task2.text_processing.entity;

/**
 * Paragraph class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 */
public class Paragraph extends AbstractComposite<Sentence> {

    @Override
    public String toString() {
        return super.toString() + "\n";
    }
}
