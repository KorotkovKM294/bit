package ru.sbt.bit.java.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Пишем свои Exceptions.
 */
public class Person {
    final String name;
    final boolean gender;
    Person spouse;

    public Person(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public void marry(Person person) {
        checkSpouse(this);
        checkSpouse(person);

        try {
            Files.write(new File("weddingBook.txt").toPath(),
                    (name + "" + person.name).getBytes());
        } catch (IOException e) {
            throw new WeddingFailedException(e);
        }

        if (gender == spouse.gender) {
            throw new IllegalStateException("No gays");
        }

        spouse = person;
        person.spouse = this;
    }

    private void checkSpouse(Person person) {
        if (person.spouse != null) {
            throw new PersonAlreadyMarriedException(person);
        }
    }
}
