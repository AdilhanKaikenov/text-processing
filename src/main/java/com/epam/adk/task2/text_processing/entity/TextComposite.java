package com.epam.adk.task2.text_processing.entity;

import java.util.List;

/**
 * Interface TextComposite created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComponent
 */
public interface TextComposite<E extends TextComponent> extends TextComponent {

    boolean add(E component);

    boolean addAll(List<E> component);

    boolean remove(E component);

    E get(int index);

    List<E> getComponents();

}
