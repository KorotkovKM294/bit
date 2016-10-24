package ru.sbt.bit.java.lesson5;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Наш exception.
 */
public class PersonAlreadyMarriedException extends RuntimeException {
    public PersonAlreadyMarriedException(Person person) {
        super(person.name + " already married " + person.spouse.name);
    }
}
