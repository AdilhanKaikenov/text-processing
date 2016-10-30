package com.epam.adk.task2.text_processing.entity;

/**
 * Interface SentenceComponent created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComponent
 */
public interface SentenceComponent extends TextComponent, Cloneable {

    SentenceComponent clone();

}
