package com.epam.adk.task2.text_processing.entity;

/**
 * PMark class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Composite
 * @see SentenceComponent
 */
public class PMark extends AbstractComposite<Symbol> implements SentenceComponent {

    @Override
    public String toString() {
        return this.toSourceString();
    }

}
