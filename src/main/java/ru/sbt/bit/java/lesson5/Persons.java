package ru.sbt.bit.java.lesson5;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public class Persons {

    public static void main(String[] args) {
        Person bob = new Person("Bob", true);
        Person marry = new Person("Marry", false);
        bob.marry(marry);

        Person dilan = new Person("Dilan", true);
        try {
            bob.marry(dilan);
        } catch (PersonAlreadyMarriedException e) {
            throw new WeddingFailedException(e);
        }
    }
}
