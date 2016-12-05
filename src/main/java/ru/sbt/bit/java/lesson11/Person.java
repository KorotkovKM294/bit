package ru.sbt.bit.java.lesson11;

/**
 * Created on 05.12.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Person {
    String name;
    String lastName;
    int age;
    Child child;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String name, String lastName, int age, Child child) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Child getChild() {
        return child;
    }
}
