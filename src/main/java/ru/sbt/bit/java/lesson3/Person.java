package ru.sbt.bit.java.lesson3;

/**
 * Created by Cyril Korotkov on 10.10.2016.
 */
public class Person implements Comparable<Person> {
    final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
