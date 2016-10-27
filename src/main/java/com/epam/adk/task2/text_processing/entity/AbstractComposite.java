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
     * The method adds all components from another List of Components to the arrayList<Components> components.
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
        for (Component component : components) {
            if (component != null) {
                builder.append(component.toSourceString());
            }
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }
}
