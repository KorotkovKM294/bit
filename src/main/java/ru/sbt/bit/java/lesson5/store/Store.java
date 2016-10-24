package ru.sbt.bit.java.lesson5.store;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public interface Store {

    public void save(String line);

    public String get();
}
