package ru.sbt.bit.java.lesson10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Сериализация
 *
 * Externalizeble
 *
 * Created on 28.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("alex", 15);
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("person.ser"))) {

        }
    }
}
