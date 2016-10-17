package ru.sbt.bit.java.lesson4.container;

/**
 * Пример generics
 * Created by Cyril Korotkov on 17.10.2016.
 */
// E, K, V, T
public interface Container<E> {
    void add(E o);

    E get(int index);

    int size();
}
