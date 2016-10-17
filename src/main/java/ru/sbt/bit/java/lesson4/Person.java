package ru.sbt.bit.java.lesson4;

/**
 * Created by KIDCLASS on 17.10.2016.
 */
public class Person implements Comparable<Person> {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
