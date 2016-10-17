package ru.sbt.bit.java.lesson4.container;

import java.util.List;

/**
 * Пример generics
 * Created by Cyril Korotkov on 17.10.2016.
 */
// E, K, V, T
public interface Container<E> {
    void add(E o);

    E get(int index);

    void addAll(Container<? extends E> source);

    void addInto(Container<? super E> destination);

    List toList();

    int size();
}
