package ru.sbt.bit.java.lesson6.reflection;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Person {
    private final String name;
    private final int age;
    private final boolean man;
    private Person spouse;

    public Person(String name, int age, boolean man) {
        this.name = name;
        this.age = age;
        this.man = man;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMan() {
        return man;
    }
}
