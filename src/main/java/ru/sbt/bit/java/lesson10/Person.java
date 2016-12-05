package ru.sbt.bit.java.lesson10;

import java.io.Serializable;

/**
 * Created on 28.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Person implements Serializable {
    transient String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
