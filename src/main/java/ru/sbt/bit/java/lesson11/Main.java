package ru.sbt.bit.java.lesson11;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

import static java.util.Comparator.comparing;

/**
 * Лямбды
 *
 * Created on 05.12.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        map.put("Q", 12);
        map.put("AAA", 9);
        map.put("B", 133);

        for (String s : map.keySet()) {
            System.out.println(s);
        }



        Map<String, Integer> mapWithLambda = new TreeMap<>(
                (Comparator<? super String>) (o1, o2) -> Integer.compare(o1.length(), o2.length())
        );



        run(() -> System.out.println("Hello"));
        run(() -> "Hello");


        Map<Person, Integer> persons = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.name.compareTo(o2.name);
                if (result != 0) return result;
                result = o1.lastName.compareTo(o2.lastName);
                if (result != 0) return result;
                return Integer.compare(o1.age, o2.age);
            }
        });

        Map<Person, Integer> goodPersons =
                new TreeMap<>(comparing(Person::getName)
                                .thenComparing(Person::getLastName)
                                .thenComparing(Person::getAge)
                );



        Runnable r = Main::sayHello;
        Callable c = Main::execute;
    }



    public static void run(Runnable runnable) {
        runnable.run();
    }
    public static void run(Callable callable) throws Exception {
        callable.call();
    }


    public static void sayHello() {
        System.out.println("Hello");
    }
    public static Person execute() {
        return new Person("as", "f", 1);
    }
}
