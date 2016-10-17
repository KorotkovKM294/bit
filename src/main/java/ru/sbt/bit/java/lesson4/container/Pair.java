package ru.sbt.bit.java.lesson4.container;

/**
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class Pair {
    private final Integer first;
    private final String second;

    public Pair(Integer first, String second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
