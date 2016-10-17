package ru.sbt.bit.java.lesson4.container;

/**
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class LongDoublePair {
    private final Long first;
    private final Double second;

    public LongDoublePair(Long first, Double second) {
        this.first = first;
        this.second = second;
    }

    public Long getFirst() {
        return first;
    }

    public Double getSecond() {
        return second;
    }
}
