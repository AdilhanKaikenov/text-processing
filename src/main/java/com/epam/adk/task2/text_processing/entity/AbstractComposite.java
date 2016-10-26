package com.epam.adk.task2.text_processing.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class AbstractComposite created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Composite
 */
public abstract class AbstractComposite<T extends Component> implements Composite<T> {

    private List<T> components;

    public AbstractComposite() {
        components = new ArrayList<>();
    }

    @Override
    public boolean add(T component) {
        return components.add(component);
    }

    @Override
    public boolean addAll(List<T> components) {
        return this.components.addAll(components);
    }

    @Override
    public boolean remove(T component) {
        return components.remove(component);
    }

    @Override
    public List<T> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String toSourceString() {
        StringBuilder builder = new StringBuilder();
        for (Component component : components) {
            if (component != null) {
                builder.append(component.toString());
            }
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return toSourceString();
    }
}
