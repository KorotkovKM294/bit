package ru.sbt.bit.java.lesson4.container;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class FixedSizeContainer<E> implements Container<E> {
    private Object[] objects;
    private int size;

    public FixedSizeContainer(int size) {
        this.objects = new Object[size];
    }

    @Override
    public void add(E o) {
        // new E() не работает
        objects[size++] = o;
    }

    @Override
    public E get(int index) {
        return (E) objects[index];
    }

    @Override
    public void addAll(Container<? extends E> source) {
        Object[] newObjects = new Object[size + source.size()];
        int i = 0;
        for (; i < size; i++) {
            newObjects[i] = objects[i];
        }
        for (int j = 0; i < size + source.size() && j < source.size(); i++, j++) {
            newObjects[i] = source.get(j);
        }
        objects = newObjects;

    }

    @Override
    public void addInto(Container<? super E> destination) {
        destination.addAll(this);
    }

    @Override
    public List toList() {
        return Arrays.asList(objects);
    }

    @Override
    public int size() {
        return objects.length;
    }
}
