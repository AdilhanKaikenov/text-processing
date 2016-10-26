package com.epam.adk.task2.text_processing.entity;

import java.util.List;

/**
 * Interface Composite created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Component
 */
public interface Composite<E extends Component> extends Component {

    boolean add(E component);

    boolean addAll(List<E> component);

    boolean remove(E component);

    List<E> getComponents();

}
