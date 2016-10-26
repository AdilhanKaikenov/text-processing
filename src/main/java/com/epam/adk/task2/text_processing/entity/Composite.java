package com.epam.adk.task2.text_processing.entity;

import java.util.List;

/**
 * Interface Composite created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Component
 */
public interface Composite<T extends Component> extends Component {

    boolean add(T component);

    boolean addAll(List<T> component);

    boolean remove(T component);

    List<T> getComponents();

}
