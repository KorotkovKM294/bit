package ru.sbt.bit.java.lesson4.container;

/**
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class FixedSizeContainer<E> implements Container<E> {
    private final Object[] objects;
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
    public int size() {
        return objects.length;
    }
}
