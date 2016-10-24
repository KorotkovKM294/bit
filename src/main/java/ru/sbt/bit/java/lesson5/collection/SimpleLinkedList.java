package ru.sbt.bit.java.lesson5.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public class SimpleLinkedList<T> implements LinkedList<T> {
    private int size = 0;

    private Node<T> first;

    private Node<T> last;

    @Override
    public void add(T o) {
        final Node<T> node = new Node<>(null, o, null);
        if (first != null) {

        }
        size++;
    }

    @Override
    public void add(int index, T o) {
        final Node<T> node = new Node<>(null, o, null);
        size++;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public List toList() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
