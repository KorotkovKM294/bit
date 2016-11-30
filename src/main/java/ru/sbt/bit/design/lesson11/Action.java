package ru.sbt.bit.design.lesson11;

/**
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public interface Action<T> {
    public void execute(T object);
}
