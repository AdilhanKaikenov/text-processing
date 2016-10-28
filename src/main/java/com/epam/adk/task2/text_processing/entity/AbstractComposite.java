package com.epam.adk.task2.text_processing.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class AbstractComposite created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Composite
 */
public abstract class AbstractComposite<E extends Component> implements Composite<E> {

    private List<E> components;

    public AbstractComposite() {
        components = new ArrayList<>();
    }

    @Override
    public boolean add(E component) {
        return components.add(component);
    }

    /**
     * The method adds all components from another List of Components to the List<Components> components.
     *
     * @param components List<Component> listComponents
     */
    @Override
    public boolean addAll(List<E> components) {
        return this.components.addAll(components);
    }

    @Override
    public boolean remove(E component) {
        return components.remove(component);
    }

    /**
     * @return ArrayList<Component> components.
     */
    @Override
    public List<E> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String toSourceString() {
        StringBuilder builder = new StringBuilder();
        toSourceString(builder);
        return builder.toString();
    }

    @Override
    public void toSourceString(StringBuilder builder) {
        for (Component component : components) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractComposite<?> that = (AbstractComposite<?>) o;

        return components != null ? components.equals(that.components) : that.components == null;

    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
