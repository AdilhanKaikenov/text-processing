package com.epam.adk.task2.text_processing.entity;

import java.util.*;

/**
 * Abstract class AbstractTextComposite created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see TextComposite
 */
public abstract class AbstractTextComposite<E extends TextComponent> implements TextComposite<E>, Iterable<E>, Cloneable {

    private List<E> components;

    public AbstractTextComposite() {
        components = new ArrayList<>();
    }

    @Override
    public boolean add(E component) {
        return components.add(component);
    }

    /**
     * The method adds all components from another List of Components to the List<Components> components.
     *
     * @param components List<TextComponent> listComponents
     */
    @Override
    public boolean addAll(List<E> components) {
        return this.components.addAll(components);
    }

    @Override
    public boolean remove(E component) {
        return components.remove(component);
    }

    @Override
    public E get(int index) {
        return components.get(index);
    }

    @Override
    public E set(int index, E element) {
        return components.set(index, element);
    }

    /**
     * @return ArrayList<TextComponent> components.
     */
    @Override
    public List<E> getComponents() {
        return components;
    }

    @Override
    public String toSourceString() {
        StringBuilder builder = new StringBuilder();
        toSourceString(builder);
        return builder.toString();
    }

    @Override
    public void toSourceString(StringBuilder builder) {
        for (TextComponent component : components) {
            if (component != null) {
                builder.append(component.toSourceString());
            }
        }
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }

    @Override
    public Iterator<E> iterator() {
        return components.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTextComposite<?> that = (AbstractTextComposite<?>) o;

        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
