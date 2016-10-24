package ru.sbt.bit.java.lesson5.collection;

import java.util.List;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Сделать имплементацию.
 */
public interface LinkedList<T> extends Iterable<T> {

    public void add(T o);

    public void add(int index, T o);

    public T getFirst();

    public T getLast();

    public List toList();

    public int size();
}
