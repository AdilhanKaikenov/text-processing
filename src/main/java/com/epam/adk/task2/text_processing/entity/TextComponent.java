package com.epam.adk.task2.text_processing.entity;

/**
 * Interface TextComponent created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 */
public interface TextComponent {

    String toSourceString();

    void toSourceString(StringBuilder builder);

}
