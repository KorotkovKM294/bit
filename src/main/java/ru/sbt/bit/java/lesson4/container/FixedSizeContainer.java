package ru.sbt.bit.java.lesson4.container;

import java.util.ArrayList;
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
        for (Object element : source.toList()) {
            this.add((E) element);
        }

    }

    @Override
    public void addInto(Container<? super E> destination) {
        destination.addAll(this);
    }

    @Override
    public List<E> toList() {
        List<E> list = new ArrayList<>();
        for (Object o : objects) {
            list.add((E) o);
        }
        return list;
    }

    @Override
    public int size() {
        return objects.length;
    }
}
